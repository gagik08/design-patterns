package com.epam.rd.autocode.observer.git.WebHook;

import com.epam.rd.autocode.observer.git.Event;

public class MergeToBranchWebHook extends WebHookImpl {
    public MergeToBranchWebHook(String branchName) {
        super(branchName, Event.Type.MERGE);
    }
}
