package christmas.domain;

import christmas.constant.Discount;
import christmas.view.output.OutputView;

public class Event {
    private final Cost cost;
    private final DiscountStatus discountStatus;

    public Event(final Cost cost, final DiscountStatus discountStatus) {
        this.cost = cost;
        this.discountStatus = discountStatus;
    }

    public final void eventView() {
        cost.orderView();
        cost.totalCostView();
    }

    public final void eventDiscountApply() {
        if (cost.isEventTarget()) {
            discountStatus.applyDiscount(Discount.CHRISTMAS);
            discountStatus.applyDiscount(cost);
        }
    }

    public final void freeGiftEventView() {
        if (cost.isFreeGiftTarget()) {
            OutputView.freeGift();
            discountStatus.applyDiscount(Discount.FREE_GIFT);
            return;
        }
        OutputView.noFreeGift();
    }

    public final void eventBadgeView() {
        OutputView.eventBadge(-discountStatus.getTotalDiscount());
    }

    public final void totalPaymentView() {
        cost.totalPaymentView(discountStatus.getTotalDiscount());
    }
}
