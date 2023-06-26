package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class CommitWebHook implements WebHook {
    private final String branch;
    private final List<Event> caughtEvents = new ArrayList<>();

    public CommitWebHook(String branch) {
        this.branch = branch;
    }

    @Override
    public String branch() {
        return branch;
    }

    @Override
    public Event.Type type() {
        return Event.Type.COMMIT;
    }

    @Override
    public List<Event> caughtEvents() {
        return caughtEvents;
    }

    @Override
    public void onEvent(Event event) {
        if (event.type() == Event.Type.COMMIT && event.branch().equals(branch)) {
            caughtEvents.add(event);
        }
    }
}
