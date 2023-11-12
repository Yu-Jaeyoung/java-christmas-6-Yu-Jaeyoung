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
}
