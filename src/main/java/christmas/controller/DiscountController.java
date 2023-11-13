package christmas.controller;

import christmas.domain.DiscountStatus;
import christmas.domain.Order;

public class DiscountController {
    private final DiscountStatus discountStatus;

    public DiscountController(final Order order) {
        this.discountStatus = new DiscountStatus(order);
    }

    public final DiscountStatus getDiscountStatus() {
        return discountStatus;
    }
}
