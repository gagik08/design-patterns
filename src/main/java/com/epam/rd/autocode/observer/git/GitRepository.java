package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class GitRepository implements Repository {
    private final List<Event> events = new ArrayList<>();
    private final List<WebHook> webHooks = new ArrayList<>();

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit commit = new Commit(author, changes);
        Event event = new Event(Event.Type.COMMIT, branch, List.of(commit));
        events.add(event);
        processEvents(event);
        return commit;
    }


    @Override
    public void merge(String sourceBranch, String targetBranch) {
        List<Commit> commits = new ArrayList<>();
        for (Event event : events) {
            if (event.type() == Event.Type.COMMIT && event.branch().equals(sourceBranch)) {
                commits.addAll(event.commits());
            }
        }
        Event mergeEvent = new Event(Event.Type.MERGE, targetBranch, commits);
        events.add(mergeEvent);
        processEvents(mergeEvent);
    }

    private void processEvents(Event event) {
        for (WebHook webHook : webHooks) {
            webHook.onEvent(event);
        }
    }
}


