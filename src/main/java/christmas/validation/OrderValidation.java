package christmas.validation;

import christmas.exception.OrderException;
import christmas.util.Parser;
import christmas.util.Splitter;

public class OrderValidation {
    public static void validate(final String input) {
        OrderException.blank(input);
        OrderException.containsBlank(input);
        OrderException.nothingBeforeComma(input);
        OrderException.nothingAfterComma(input);
        OrderException.noHyphen(input);
    }

    public static void validateAfterSplitWithComma(final String input) {
        final String[] menus = Splitter.splitWithComma(input);

        OrderException.noHyphen(menus);
        OrderException.nothingBeforeHyphen(menus);
        OrderException.nothingAfterHyphen(menus);
    }

    public static void validateAfterSplitWithHyphen(final String input) {
        final String[] menus = Splitter.splitWithComma(input);
        int menuCount = 0;

        OrderException.duplicatedMenu(menus);
        OrderException.onlyBeverage(menus);

        for (final String menu : menus) {
            final String[] order = Splitter.splitWithHyphen(menu);
            OrderException.notInMenu(order[0]);
            OrderException.notInRangeNumber(order[1]);
            menuCount += Parser.stringToInt(order[1]);
        }
        OrderException.menuCountOver(menuCount);
    }
}
