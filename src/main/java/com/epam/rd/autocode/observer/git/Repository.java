package com.epam.rd.autocode.observer.git;

import com.epam.rd.autocode.observer.git.WebHook.WebHook;

public interface Repository {
    void addWebHook(WebHook webHook);

    Commit commit(String branch, String author, String[] changes);

    void merge(String sourceBranch, String targetBranch);

}
