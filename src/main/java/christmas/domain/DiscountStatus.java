package christmas.domain;

import christmas.constant.Discount;

import java.util.HashMap;
import java.util.Map;

public class DiscountStatus {
    private final Map<Discount, Integer> discountStatus;
    private final Order order;
    private final int totalCost;

    public DiscountStatus(final Order order, final int totalCost) {
        this.discountStatus = initializeDiscountStatus();
        this.order = order;
        this.totalCost = totalCost;
    }

    private Map<Discount, Integer> initializeDiscountStatus() {
        final Map<Discount, Integer> discountStatus = new HashMap<>();

        for (final Discount discount : Discount.values()) {
            discountStatus.put(discount, 0);
        }

        return discountStatus;
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

    public final int getDiscount(final Discount discount) {
        if (discount.equals(Discount.CHRISTMAS)) {
            return -(100 * (this.discountStatus.get(discount) - 1) + discount.getDiscountValue());
        }

        return -this.discountStatus.get(discount) * discount.getDiscountValue();
    }

    public final int getTotalDiscount() {
        int totalDiscount = 0;

        for (final Discount discount : Discount.values()) {
            totalDiscount += getDiscount(discount);
        }

        return totalDiscount;
    }

    public final int totalPayment() {
        return this.totalCost + getTotalDiscount();
    }
}
