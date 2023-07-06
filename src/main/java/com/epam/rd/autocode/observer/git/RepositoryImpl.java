package com.epam.rd.autocode.observer.git;

import com.epam.rd.autocode.observer.git.WebHook.WebHook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryImpl implements Repository{
    private final List<WebHook> webHooks;
    private final Map<String, List<Commit>> branches;

    public RepositoryImpl() {
        this.webHooks = new ArrayList<>();
        this.branches = new HashMap<>();
    }

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit commit = new Commit(author, changes);
        Event event = new Event(Event.Type.COMMIT, branch, Collections.singletonList(commit));

        if (!branches.containsKey(branch)) {
            branches.put(branch, new ArrayList<>());
        }

        branches.get(branch).add(commit);

        for (WebHook webHook : webHooks) {
            if (webHook.branch().equals(branch) && webHook.type() == Event.Type.COMMIT) {
                webHook.onEvent(event);
            }
        }

        return commit;
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        List<WebHook> webHooksForSourceBranch = getWebHooksForBranch(sourceBranch);
        List<WebHook> webHooksForTargetBranch = getWebHooksForBranch(targetBranch);
        List<Commit> mergedCommits = new ArrayList<>();

        for (WebHook mergeWebHook : webHooksForTargetBranch) {
            if (mergeWebHook.type() == Event.Type.MERGE) {
                for (WebHook commitWebHook : webHooksForSourceBranch) {
                    if (commitWebHook.branch().equals(sourceBranch) && commitWebHook.type() == Event.Type.COMMIT) {
                        List<Event> commitEvents = commitWebHook.caughtEvents();
                        for (Event event : commitEvents) {
                            List<Commit> commits = event.commits();
                            mergedCommits.addAll(commits);
                        }
                    }
                }

                Event event = new Event(Event.Type.MERGE, targetBranch, mergedCommits);
                mergeWebHook.onEvent(event);
            }
        }
    }

    private List<WebHook> getWebHooksForBranch(String branch) {
        List<WebHook> filteredWebHooks = new ArrayList<>();
        for (WebHook webHook : webHooks) {
            if (webHook.branch().equals(branch)) {
                filteredWebHooks.add(webHook);
            }
        }
        return filteredWebHooks;
    }
}