package com.epam.rd.autocode.observer.git.WebHook;


import com.epam.rd.autocode.observer.git.Event;

import java.util.ArrayList;
import java.util.List;

public class WebHookImpl implements WebHook {
    private final String branch;
    private final Event.Type type;
    private final List<Event> events;

    public WebHookImpl(String branch, Event.Type type) {
        this.branch = branch;
        this.type = type;
        this.events = new ArrayList<>();
    }

    @Override
    public String branch() {
        return branch;
    }

    @Override
    public Event.Type type() {
        return type;
    }

    @Override
    public List<Event> caughtEvents() {
        return events;
    }

    @Override
    public void onEvent(Event event) {
        events.add(event);
    }

    @Override
    public void notify(Event event) {
        if (event.type() == type && event.branch().equals(branch)) {
            onEvent(event);
        }
    }
}
