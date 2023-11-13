package christmas.domain;

import christmas.constant.Discount;
import christmas.view.output.OutputView;

public class Event {
    private final Cost cost;
    private final Calendar calendar;

    public Event(final Calendar calendar, final Cost cost) {
        this.calendar = calendar;
        this.cost = cost;
    }

    public final void weekendOrDayDiscount(final DiscountStatus discountStatus, final Order order) {
        if (calendar.isWeekend()) {
            discountStatus.applyDiscount(Discount.WEEKEND, order);
            return;
        }
        discountStatus.applyDiscount(Discount.WEEKDAY, order);
    }

    public final void specialDiscount(final DiscountStatus discountStatus) {
        if (calendar.isStarDay()) {
            discountStatus.applyDiscount(Discount.SPECIAL);
        }
    }

    public final void christmasDiscount(final DiscountStatus discountStatus) {
        discountStatus.applyDiscount(Discount.CHRISTMAS, calendar.christmasDDay());
    }

    public final void freeGiftDiscount(final DiscountStatus discountStatus) {
        if (cost.isFreeGiftTarget()) {
            discountStatus.applyDiscount(Discount.FREE_GIFT);
        }
    }

    public final void freeGiftEventView() {
        if (cost.isFreeGiftTarget()) {
            OutputView.freeGift();
            return;
        }
        OutputView.noFreeGift();
    }

    public final void eventBadgeView(final DiscountStatus discountStatus) {
        OutputView.eventBadge(discountStatus.getTotalDiscount());
    }
}
