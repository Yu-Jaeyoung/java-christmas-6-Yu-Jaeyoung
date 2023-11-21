package christmas.controller;

import christmas.domain.Cost;
import christmas.domain.Order;

public class CostController {
    private final Cost cost;

    public CostController(final Order order) {
        this.cost = new Cost(order);
    }

    public final Cost getCost() {
        return cost;
    }
}
