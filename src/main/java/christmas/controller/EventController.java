package christmas.controller;

import christmas.domain.Cost;
import christmas.domain.DiscountStatus;
import christmas.domain.Event;

public class EventController {
    private final Event event;

    public EventController(final Cost cost, final DiscountStatus discountStatus) {
        this.event = new Event(cost, discountStatus);
    }

    public final void eventDiscountApply() {
        event.eventDiscountApply();
    }

    public final void freeGiftEventView() {
        event.freeGiftEventView();
    }

    public final void eventBadgeView() {
        event.eventBadgeView();
    }

    public final void totalPaymentView() {
        event.totalPaymentView();
    }
}
