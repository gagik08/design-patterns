package com.epam.rd.autocode.observer.git;

public class GitRepoObservers {
    private GitRepoObservers() {
        // Private constructor to hide the implicit public one
    }
    public static Repository newRepository() {
        return new GitRepository();
    }

    public static WebHook mergeToBranchWebHook(String branchName) {
        return new MergeWebHook(branchName);
    }

    public static WebHook commitToBranchWebHook(String branchName) {
        return new CommitWebHook(branchName);
    }
}

