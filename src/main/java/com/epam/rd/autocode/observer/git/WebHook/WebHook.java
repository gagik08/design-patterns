package com.epam.rd.autocode.observer.git.WebHook;


import com.epam.rd.autocode.observer.git.Event;

import java.util.List;

public interface WebHook {
    String branch();
    Event.Type type();
    List<Event> caughtEvents();
    void onEvent(Event event);
    void notify(Event event);
}
