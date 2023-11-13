package christmas.controller;

import christmas.domain.Calendar;
import christmas.domain.Cost;
import christmas.domain.Event;

public class EventController {
    private final Event event;

    public EventController(final Calendar calendar, final Cost cost) {
        this.event = new Event(calendar, cost);
    }

    public final Event getEvent() {
        return event;
    }
}
