package christmas.domain;

import christmas.constant.Discount;
import christmas.constant.Menu;

import java.util.HashMap;
import java.util.Map;

public class Cost {
    private final Order order;
    private final int totalCost;
    private final Map<Discount, Integer> discount = new HashMap<>();
    private int christmasDiscount = 0;
    private int weekendDiscount = 0;
    private int weekdayDiscount = 0;
    private int specialDiscount = 0;
    private int freeGiftDiscount = 0;

    public Cost(final Order order) {
        this.order = order;
        this.totalCost = initializeTotalCost(order);
    }

    public final int initializeTotalCost(final Order order) {
        int totalCost = 0;

        for (final Map.Entry<Menu, Integer> menu : order.getOrderHistory().entrySet()) {
            final Menu menuName = menu.getKey();
            final int quantity = menu.getValue();

            totalCost += (menuName.getPrice() * quantity);
        }

        return totalCost;
    }

    public final boolean isFreeGiftTarget() {
        return totalCost >= 120_000;
    }

    public final boolean isEventTarget() {
        return totalCost >= 10_000;
    }

    public final int getTotalCost() {
        return totalCost;
    }

    public final int getTotalCostAfterDiscount() {
        return totalCost + getBenefitCost() - freeGiftDiscount;
    }

    public final int getChristmasDiscount() {
        return christmasDiscount;
    }

    public final int getWeekendDiscount() {
        return weekendDiscount;
    }

    public final int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public final int getSpecialDiscount() {
        return specialDiscount;
    }

    public final int getFreeGiftDiscount() {
        return freeGiftDiscount;
    }

    public final int getBenefitCost() {
        return christmasDiscount + weekendDiscount + weekdayDiscount + specialDiscount + freeGiftDiscount;
    }

    public final void applyWeekendDiscount() {
        weekendDiscount += -2_023 * order.getMainQuantity();
    }

    public final void applyWeekdayDiscount() {
        weekdayDiscount += -2_023 * order.getDessertQuantity();
    }

    public final void applySpecialDiscount() {
        specialDiscount += -1_000;
    }

    public final void applyChristmasDiscount(final int date) {
        christmasDiscount += -1_000 - (100 * (date - 1));
    }

    public final void applyFreeGiftDiscount() {
        freeGiftDiscount += -25_000;
    }
}
