package christmas.controller;

import christmas.domain.Order;

public class OrderController {
    private final Order order;

    public OrderController(final String order) {
        this.order = new Order(order);
    }

    public final Order getOrder() {
        return order;
    }
}
