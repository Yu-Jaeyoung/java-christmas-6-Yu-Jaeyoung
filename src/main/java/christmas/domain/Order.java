package christmas.domain;

import christmas.constant.Menu;
import christmas.util.Parser;
import christmas.util.Splitter;
import christmas.view.output.OutputView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<Menu, Integer> orderHistory;

    public Order(final String order) {
        this.orderHistory = orderHistory(order);
    }

    private Map<Menu, Integer> orderHistory(final String input) {
        final Map<Menu, Integer> orderHistory = new HashMap<>();
        final String[] menuWithCount = Splitter.splitWithComma(input);

        for (final String Order : menuWithCount) {
            orderHistory.put(Parser.stringToMenu(Splitter.splitWithHyphen(Order)[0]),
                    Parser.stringToInt(Splitter.splitWithHyphen(Order)[1]));
        }

        return orderHistory;
    }

    public final Map<Menu, Integer> getOrderHistory() {
        return Collections.unmodifiableMap(this.orderHistory);
    }

    public final int getMainQuantity() {
        int mainQuantity = 0;

        for (final Map.Entry<Menu, Integer> menu : this.orderHistory.entrySet()) {
            if (menu.getKey().getCourse().equals("main")) {
                mainQuantity += menu.getValue();
            }
        }

        return mainQuantity;
    }

    public final int getDessertQuantity() {
        int dessertQuantity = 0;

        for (final Map.Entry<Menu, Integer> menu : this.orderHistory.entrySet()) {
            if (menu.getKey().getCourse().equals("dessert")) {
                dessertQuantity += menu.getValue();
            }
        }

        return dessertQuantity;
    }

    public final void orderView() {
        OutputView.order(this.orderHistory);
    }
}
