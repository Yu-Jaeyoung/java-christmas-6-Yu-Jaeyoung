package christmas.view;

import christmas.constant.Menu;
import christmas.constant.Phrase;
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
}
