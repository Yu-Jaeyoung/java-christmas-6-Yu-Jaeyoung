package christmas.domain;

import christmas.constant.Menu;
import java.util.Map;

public class Cost {
    public static int totalCost(final Map<Menu, Integer> orderHistory) {
        int totalCost = 0;

        for (final Map.Entry<Menu, Integer> menu : orderHistory.entrySet()) {
            final Menu menuName = menu.getKey();
            final int quantity = menu.getValue();

            totalCost = totalCost + (menuName.getPrice() * quantity);
        }

        return totalCost;
    }
}
