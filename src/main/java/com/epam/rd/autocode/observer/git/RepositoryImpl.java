package com.epam.rd.autocode.observer.git;

import com.epam.rd.autocode.observer.git.WebHook.WebHook;

import java.util.*;

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
        if (!branches.containsKey(branch)) {
            branches.put(branch, new ArrayList<>());
        }
        branches.get(branch).add(commit);
        Event event = new Event(Event.Type.COMMIT, branch, Collections.singletonList(commit));
        notifyWebHooks(event);
        return commit;
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        List<Commit> sourceCommits = branches.get(sourceBranch);
        if (sourceCommits == null) {
            throw new IllegalArgumentException("Source branch does not exist");
        }

        List<Commit> targetCommits = branches.get(targetBranch);
        if (targetCommits == null) {
            targetCommits = new ArrayList<>();
            branches.put(targetBranch, targetCommits);
        }

        for (Commit commit : sourceCommits) {
            if (!targetCommits.contains(commit)) {
                targetCommits.add(commit);
            }
        }

        Event event = new Event(Event.Type.MERGE, targetBranch, new ArrayList<>(targetCommits));
        notifyWebHooks(event);
    }



    private void notifyWebHooks(Event event) {
        for (WebHook webHook : webHooks) {
            webHook.notify(event);
        }
    }
}
