package christmas.controller;

import christmas.domain.Calendar;

public class DateController {
    private final Calendar calendar;

    public DateController(final int date) {
        this.calendar = new Calendar(date);
    }

    public final Calendar getCalendar() {
        return calendar;
    }
}
