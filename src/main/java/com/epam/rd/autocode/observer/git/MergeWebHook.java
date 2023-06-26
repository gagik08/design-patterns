package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class MergeWebHook implements WebHook {
    private String branch;
    private List<Event> caughtEvents = new ArrayList<>();

    public MergeWebHook(String branch) {
        this.branch = branch;
    }

    @Override
    public String branch() {
        return branch;
    }

    @Override
    public Event.Type type() {
        return Event.Type.MERGE;
    }

    @Override
    public List<Event> caughtEvents() {
        return caughtEvents;
    }

    @Override
    public void onEvent(Event event) {
        if (event.type() == Event.Type.MERGE && event.branch().equals(branch)) {
            caughtEvents.add(event);
        }
    }
}