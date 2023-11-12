package christmas.controller;

import christmas.domain.Calendar;
import christmas.domain.Cost;
import christmas.domain.Event;
import christmas.domain.Order;

public class EventController {
    public static void checkEvent(final int date, final String menus) {
        final Order order = new Order(menus);
        final Cost cost = new Cost(order);
        final Event event = new Event(new Calendar(date), cost);

        order.orderMenuView();
        event.eventApplier();
        event.eventPlannerView();
    }
}
