package christmas.view;

import christmas.constant.Menu;
import christmas.constant.Phrase;
import christmas.util.Formatter;

import java.util.Map;

public class OutputView {
    public static void orderMenu(final Map<Menu, Integer> orderHistory) {
        System.out.println(Phrase.EVENT_PREVIEW);
        System.out.println(Phrase.ORDER_MENU);

        for (final Map.Entry<Menu, Integer> menu : orderHistory.entrySet()) {
            final String menuName = menu.getKey().getMenuName();
            final int quantity = menu.getValue();

            System.out.println(menuName + " " + quantity + "개");
        }
    }

    public static void noBenefit(final int totalCost) {
        System.out.println(Phrase.BENEFIT + "\n" + Phrase.NOTHING);
        System.out.println(Phrase.BENEFIT_COST + "\n0원");
        System.out.println(Phrase.TOTAL_COST_AFTER_DISCOUNT);
        System.out.println(Formatter.decimalFormatter(totalCost) + "원\n");
        System.out.println(Phrase.EVENT_BADGE + "\n" + Phrase.NOTHING);
    }

    public static void totalCostBeforeDiscount(final int totalCost) {
        System.out.println(Phrase.TOTAL_COST_BEFORE_DISCOUNT);
        System.out.println(Formatter.decimalFormatter(totalCost) + "원");
    }

    public static void freeGift() {
        System.out.println(Phrase.FREE_GIFT);
        System.out.println(Phrase.FREE_GIFT_MENU);
    }

    public static void noFreeGift() {
        System.out.println(Phrase.FREE_GIFT);
        System.out.println(Phrase.NOTHING);
    }

    public static void weekendDiscount(final int discount) {
        if (discount != 0) {
            System.out.print(Phrase.WEEKEND_DISCOUNT);
            System.out.println(Formatter.decimalFormatter(discount) + "원");
        }
    }

    public static void weekdayDiscount(final int discount) {
        if (discount != 0) {
            System.out.print(Phrase.WEEKDAY_DISCOUNT);
            System.out.println(Formatter.decimalFormatter(discount) + "원");
        }
    }

    public static void specialDiscount(final int discount) {
        if (discount != 0) {
            System.out.print(Phrase.SPECIAL_DISCOUNT);
            System.out.println(Formatter.decimalFormatter(discount) + "원");
        }
    }

    public static void christmasDiscount(final int discount) {
        if (discount != 0) {
            System.out.print(Phrase.CHRISTMAS_DISCOUNT);
            System.out.println(Formatter.decimalFormatter(discount) + "원");
        }
    }

    public static void freeGiftDiscount(final int discount) {
        if (discount != 0) {
            System.out.print(Phrase.FREE_GIFT_EVENT);
            System.out.println(Formatter.decimalFormatter(discount) + "원");
        }
    }

    public static void benefitCost(final int discount) {
        System.out.println(Phrase.BENEFIT_COST);
        System.out.println(Formatter.decimalFormatter(discount) + "원");
    }

    public static void totalCostAfterDiscount(final int discount) {
        System.out.println(Phrase.TOTAL_COST_AFTER_DISCOUNT);
        System.out.println(Formatter.decimalFormatter(discount) + "원");
    }

    public static void eventBadge(final int discount) {
        if (discount >= 20_000) {
            System.out.println(Phrase.EVENT_BADGE + "\n" + Phrase.EVENT_BADGE_SANTA);
            return;
        }
        if (discount >= 10_000) {
            System.out.println(Phrase.EVENT_BADGE + "\n" + Phrase.EVENT_BADGE_TREE);
            return;
        }
        if (discount >= 5_000) {
            System.out.println(Phrase.EVENT_BADGE + "\n" + Phrase.EVENT_BADGE_STAR);
            return;
        }
        System.out.println(Phrase.EVENT_BADGE + "\n" + Phrase.NOTHING);
    }
}
