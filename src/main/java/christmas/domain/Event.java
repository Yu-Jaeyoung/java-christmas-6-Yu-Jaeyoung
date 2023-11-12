package christmas.domain;

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
            cost.applyWeekendDiscount();
            return;
        }
        cost.applyWeekdayDiscount();
    }

    private void specialDiscount() {
        if (calendar.isStarDay()) {
            cost.applySpecialDiscount();
        }
    }

    private void christmasDiscount() {
        if (calendar.isChristmasDDay()) {
            cost.applyChristmasDiscount(calendar.getDate());
        }
    }

    private void freeGiftDiscount() {
        if (cost.getTotalCostBeforeDiscount() >= 120_000) {
            cost.applyFreeGiftDiscount();
        }
    }

    public final void eventApplier() {
        weekendOrDayDiscount();
        specialDiscount();
        christmasDiscount();
        freeGiftDiscount();
    }

    private void totalCostBeforeDiscountView() {
        DiscountView.totalCostBeforeDiscount(cost.getTotalCostBeforeDiscount());
    }

    private void freeGiftEventView() {
        if (cost.getTotalCostBeforeDiscount() > 120_000) {
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

        if (cost.getBenefitCost() == 0 || cost.getTotalCostBeforeDiscount() < 10_000) {
            OutputView.noBenefit(cost.getTotalCostBeforeDiscount());
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
