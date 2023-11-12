package christmas.domain;

import christmas.constant.Menu;

import java.util.Map;

public class Event {
    private final Map<Menu, Integer> orderHistory;
    private final Calendar calendar;
    private final int totalCost;

    public Event(final Map<Menu, Integer> orderHistory, final Calendar calendar) {
        this.orderHistory = orderHistory;
        this.totalCost = Cost.totalCost(orderHistory);
        this.calendar = calendar;
    }
}
