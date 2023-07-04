package com.epam.rd.autocode.observer.git.WebHook;

import com.epam.rd.autocode.observer.git.Event;

public class CommitToBranchWebHook extends WebHookImpl {
    public CommitToBranchWebHook(String branchName) {
        super(branchName, Event.Type.COMMIT);
    }

}
