package christmas.view.output;

import christmas.constant.Phrase;
import christmas.util.Formatter;

public class DiscountView {
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
}
