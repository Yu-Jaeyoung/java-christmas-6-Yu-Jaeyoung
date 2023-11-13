package christmas.domain;

import christmas.constant.Discount;
import christmas.constant.Phrase;
import christmas.view.output.DiscountView;
import christmas.view.output.OutputView;

public class Event {
    private final Calendar calendar;
    private final Cost cost;

    public Event(final Calendar calendar, final Cost cost) {
        this.calendar = calendar;
        this.cost = cost;
    }

    private void weekendOrDayDiscount() {
        if (calendar.isWeekend()) {
            cost.applyDiscount(Discount.WEEKEND);
            return;
        }
        cost.applyDiscount(Discount.WEEKDAY);
    }

    private void specialDiscount() {
        if (calendar.isStarDay()) {
            cost.applyDiscount(Discount.SPECIAL);
        }
    }

    private void christmasDiscount() {
        if (calendar.isChristmasDDay()) {
            cost.applyDiscount(Discount.CHRISTMAS, calendar.getDate());
        }
    }

    private void freeGiftDiscount() {
        if (cost.isFreeGiftTarget()) {
            cost.applyDiscount(Discount.FREE_GIFT);
        }
    }

    public final void eventApplier() {
        weekendOrDayDiscount();
        specialDiscount();
        christmasDiscount();
        freeGiftDiscount();
    }

    private void totalCostBeforeDiscountView() {
        DiscountView.totalCostBeforeDiscount(cost.getTotalCost());
    }

    private void freeGiftEventView() {
        if (cost.isFreeGiftTarget()) {
            OutputView.freeGift();
            return;
        }

        OutputView.noFreeGift();
    }

    private void totalCostAfterDiscountView() {
        DiscountView.totalCostAfterDiscount(cost.getTotalCostAfterDiscount());
    }

    private void eventBadgeView() {
        OutputView.eventBadge(-cost.getBenefitCost());
    }

    private void benefitDetailView() {
        System.out.println(Phrase.BENEFIT);

        if (cost.getBenefitCost() == 0 || !cost.isEventTarget()) {
            OutputView.noBenefit(cost.getTotalCost());
            return;
        }

        DiscountView.weekdayDiscount(cost.getWeekdayDiscount());
        DiscountView.weekendDiscount(cost.getWeekendDiscount());
        DiscountView.specialDiscount(cost.getSpecialDiscount());
        DiscountView.christmasDiscount(cost.getChristmasDiscount());
        DiscountView.freeGiftDiscount(cost.getFreeGiftDiscount());
        OutputView.benefitCost(cost.getBenefitCost());
        totalCostAfterDiscountView();
        eventBadgeView();
    }

    public final void eventPlannerView() {
        totalCostBeforeDiscountView();
        freeGiftEventView();
        benefitDetailView();
    }
}
