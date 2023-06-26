package com.epam.rd.autocode.observer.git;
import java.util.*;
import java.util.stream.Collectors;

public class GitRepoObservers {
    private static Repository repository = new RepositoryImpl();
    private static Map<String, List<WebHook>> mergeObservers = new HashMap<>();
    private static Map<String, List<WebHook>> commitObservers = new HashMap<>();

    public static Repository newRepository() {
        return repository;
    }

    public static WebHook mergeToBranchWebHook(String branchName) {
        WebHook webHook = new WebHookImpl(branchName);
        mergeObservers.computeIfAbsent(branchName, key -> new ArrayList<>()).add(webHook);
        return webHook;
    }

    public static WebHook commitToBranchWebHook(String branchName) {
        WebHook webHook = new WebHookImpl(branchName);
        commitObservers.computeIfAbsent(branchName, key -> new ArrayList<>()).add(webHook);
        return webHook;
    }

    private static class RepositoryImpl implements Repository {
        private List<WebHook> webHooks = new ArrayList<>();

        @Override
        public void addWebHook(WebHook webHook) {
            webHooks.add(webHook);
        }

        @Override
        public Commit commit(String branch, String author, String[] changes) {
            Commit commit = new Commit(author, changes);
            Event event = new Event(Event.Type.COMMIT, branch, List.of(commit));
            notifyCommitObservers(branch, event);
            return commit;
        }

        @Override
        public void merge(String sourceBranch, String targetBranch) {
            List<Commit> commits = new ArrayList<>();

            for (WebHook webHook : commitObservers.getOrDefault(sourceBranch, new ArrayList<>())) {
                List<Commit> webHookCommits = webHook.caughtEvents().stream()
                        .filter(event -> event.type() == Event.Type.COMMIT)
                        .flatMap(event -> event.commits().stream())
                        .collect(Collectors.toList());

                commits.addAll(webHookCommits);
            }

            Event event = new Event(Event.Type.MERGE, targetBranch, commits);
            notifyMergeObservers(targetBranch, event);
        }



        private void notifyCommitObservers(String branch, Event event) {
            List<Commit> commits = event.commits();
            Event mergedEvent = new Event(Event.Type.COMMIT, event.branch(), commits);
            for (WebHook webHook : commitObservers.getOrDefault(branch, new ArrayList<>())) {
                webHook.onEvent(mergedEvent);
            }
        }

        private void notifyMergeObservers(String branch, Event event) {
            for (WebHook webHook : mergeObservers.getOrDefault(branch, new ArrayList<>())) {
                webHook.onEvent(event);
            }
        }
    }


    private static class WebHookImpl implements WebHook {
        private String branch;
        private List<Event> caughtEvents;

        public WebHookImpl(String branch) {
            this.branch = branch;
            this.caughtEvents = new ArrayList<>();
        }

        @Override
        public String branch() {
            return branch;
        }

        @Override
        public Event.Type type() {
            return null; // Not used in this implementation
        }

        @Override
        public List<Event> caughtEvents() {
            return caughtEvents;
        }

        @Override
        public void onEvent(Event event) {
            caughtEvents.add(event);
        }
    }
}
