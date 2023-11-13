package christmas.view.output;

import christmas.constant.Discount;
import christmas.util.Formatter;

public class DiscountView {

    public static void discountView(final Discount discount, final int discountValue) {
        if (discountValue != 0) {
            System.out.printf("%s%s원\n", discount.getDiscountPhrase(), Formatter.decimalFormatter(discountValue));
        }
    }
}