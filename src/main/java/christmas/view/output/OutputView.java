package christmas.view.output;

import christmas.constant.Menu;
import christmas.constant.Phrase;

import java.util.Map;

public class OutputView {
    static final String ORDER_MENU = "<주문 메뉴>";
    static final String FREE_GIFT = "<증정 메뉴>";
    static final String FREE_GIFT_MENU = "샴페인 1개";
    static final String EVENT_BADGE_SANTA = "산타";
    static final String EVENT_BADGE_TREE = "트리";
    static final String EVENT_BADGE_STAR = "별";

    public static void order(final Map<Menu, Integer> orderHistory) {
        System.out.println(ORDER_MENU);

        for (final Map.Entry<Menu, Integer> menu : orderHistory.entrySet()) {
            final String menuName = menu.getKey().getMenuName();
            final int quantity = menu.getValue();

            System.out.println(menuName + " " + quantity + "개");
        }
    }

    public static void freeGift() {
        System.out.printf("%s\n%s\n", FREE_GIFT, FREE_GIFT_MENU);
    }

    public static void noFreeGift() {
        System.out.printf("%s\n%s\n", FREE_GIFT, Phrase.NOTHING);
    }

    public static void eventBadge(final int discount) {
        if (discount >= 20_000) {
            System.out.print(Phrase.EVENT_BADGE + EVENT_BADGE_SANTA);
            return;
        }
        if (discount >= 10_000) {
            System.out.print(Phrase.EVENT_BADGE + EVENT_BADGE_TREE);
            return;
        }
        if (discount >= 5_000) {
            System.out.print(Phrase.EVENT_BADGE + EVENT_BADGE_STAR);
            return;
        }
        System.out.print(Phrase.EVENT_BADGE + Phrase.NOTHING);
    }
}
