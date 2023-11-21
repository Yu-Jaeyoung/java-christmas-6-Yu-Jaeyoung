package christmas.domain;

import christmas.constant.Discount;

import java.util.HashMap;
import java.util.Map;

public class DiscountStatus {
    private final Calendar calendar;
    private final Map<Discount, Integer> discountStatus;

    public DiscountStatus(final Calendar calendar) {
        this.calendar = calendar;
        this.discountStatus = initializeDiscountStatus();
    }

    public final void eventPreview() {
        calendar.eventPreview();
    }

    private Map<Discount, Integer> initializeDiscountStatus() {
        final Map<Discount, Integer> discountStatus = new HashMap<>();

        for (final Discount discount : Discount.values()) {
            discountStatus.put(discount, 0);
        }

        return discountStatus;
    }

    public final void applyDiscount(final Discount discount) {
        if (discount.equals(Discount.CHRISTMAS)) {
            this.discountStatus.put(discount, calendar.christmasDDay());
        }

        if (discount.equals(Discount.FREE_GIFT)) {
            this.discountStatus.put(discount, 1);
        }
    }

    public final void applyDiscount(final Cost cost) {
        if (calendar.isStarDay()) {
            this.discountStatus.put(Discount.SPECIAL, 1);
        }

        if (calendar.isWeekend()) {
            this.discountStatus.put(Discount.WEEKEND, cost.getDessertQuantity());
            return;
        }

        this.discountStatus.put(Discount.WEEKDAY, cost.getMainQuantity());
    }

    public final int getDiscount(final Discount discount) {
        if (discount.equals(Discount.CHRISTMAS) && this.discountStatus.get(discount) != 0) {
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
}
