package christmas.domain;

import christmas.constant.Menu;
import christmas.util.Parser;
import christmas.util.Splitter;

import java.util.HashMap;
import java.util.Map;

public class Order {
    public static Map<Menu, Integer> orderHistory(final String input) {
        final Map<Menu, Integer> orderHistory = new HashMap<>();
        final String[] menuWithCount = Splitter.splitWithComma(input);

        for (final String Order : menuWithCount) {
            orderHistory.put(Parser.stringToMenu(Splitter.splitWithHyphen(Order)[0]),
                    Parser.stringToInt(Splitter.splitWithHyphen(Order)[1]));
        }

        return orderHistory;
    }
}
