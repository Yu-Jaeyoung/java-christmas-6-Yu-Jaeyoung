package christmas.domain;

import christmas.constant.Discount;
import christmas.constant.Menu;

import java.util.HashMap;
import java.util.Map;

public class Cost {
    private final Order order;
    private final int totalCost;
    private final Map<Discount, Integer> discountStatus;
    private int christmasDiscount = 0;
    private int weekendDiscount = 0;
    private int weekdayDiscount = 0;
    private int specialDiscount = 0;
    private int freeGiftDiscount = 0;

    public Cost(final Order order) {
        this.order = order;
        this.totalCost = initializeTotalCost(order);
        this.discountStatus = initializeDiscountStatus();
    }

    private int initializeTotalCost(final Order order) {
        int totalCost = 0;

        for (final Map.Entry<Menu, Integer> menu : order.getOrderHistory().entrySet()) {
            final Menu menuName = menu.getKey();
            final int quantity = menu.getValue();

            totalCost += (menuName.getPrice() * quantity);
        }

        return totalCost;
    }

    private Map<Discount, Integer> initializeDiscountStatus() {
        final Map<Discount, Integer> discountStatus = new HashMap<>();

        for (final Discount discount : Discount.values()) {
            discountStatus.put(discount, 0);
        }

        return discountStatus;
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

    public final void applyDiscount(final Discount discount) {
        if (discount.equals(Discount.SPECIAL) || discount.equals(Discount.FREE_GIFT)) {
            this.discountStatus.put(discount, 1);
        }

        if (discount.equals(Discount.WEEKDAY)) {
            this.discountStatus.put(discount, order.getDessertQuantity());
        }

        if (discount.equals(Discount.WEEKEND)) {
            this.discountStatus.put(discount, order.getMainQuantity());
        }
    }

    public final void applyDiscount(final Discount discount, final int date) {
        if (discount.equals(Discount.CHRISTMAS)) {
            this.discountStatus.put(discount, date);
        }
    }
}