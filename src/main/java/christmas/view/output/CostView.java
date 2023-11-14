package christmas.view.output;

import christmas.util.Formatter;

public class CostView {
    static final String TOTAL_COST_BEFORE_DISCOUNT = "\n<할인 전 총주문 금액>\n";
    static final String TOTAL_COST_AFTER_DISCOUNT = "\n<할인 후 예상 결제 금액>\n";

    public static void totalCostBeforeDiscount(final int totalCost) {
        System.out.printf("%s%s원\n\n", TOTAL_COST_BEFORE_DISCOUNT, Formatter.decimalFormatter(totalCost));
    }

    public static void totalCostAfterDiscount(final int discount) {
        System.out.printf("%s%s원\n", TOTAL_COST_AFTER_DISCOUNT, Formatter.decimalFormatter(discount));
    }
}
