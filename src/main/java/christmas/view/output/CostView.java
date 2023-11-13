package christmas.view.output;

import christmas.constant.Phrase;
import christmas.util.Formatter;

public class CostView {
    public static void totalCostBeforeDiscount(final int totalCost) {
        System.out.println(Phrase.TOTAL_COST_BEFORE_DISCOUNT);
        System.out.println(Formatter.decimalFormatter(totalCost) + "원");
    }

    public static void totalCostAfterDiscount(final int discount) {
        System.out.println(Phrase.TOTAL_COST_AFTER_DISCOUNT);
        System.out.println(Formatter.decimalFormatter(discount) + "원");
    }
}
