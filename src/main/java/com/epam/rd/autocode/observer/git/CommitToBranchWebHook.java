package com.epam.rd.autocode.observer.git;

public class CommitToBranchWebHook extends WebHookImpl {
    public CommitToBranchWebHook(String branchName) {
        super(branchName, Event.Type.COMMIT);
    }

}
