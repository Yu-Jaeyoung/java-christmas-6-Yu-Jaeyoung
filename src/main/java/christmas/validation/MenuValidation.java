package christmas.validation;

import christmas.exception.MenuException;
import christmas.util.Splitter;

public class MenuValidation {
    public static void validate(final String input) {
        MenuException.blank(input);
        MenuException.containsBlank(input);
        MenuException.nothingBeforeComma(input);
        MenuException.nothingAfterComma(input);
        MenuException.noHyphen(input);
    }

    public static void validateAfterSplitWithComma(final String input) {
        final String[] menus = Splitter.splitWithComma(input);

        MenuException.noHyphen(menus);
        MenuException.nothingBeforeHyphen(menus);
        MenuException.nothingAfterHyphen(menus);
    }

    public static void validateAfterSplitWithHyphen(final String input) {
        final String[] menus = Splitter.splitWithComma(input);

        MenuException.duplicatedMenu(menus);

        for (final String menu : menus) {
            final String[] order = Splitter.splitWithHyphen(menu);
            MenuException.notInMenu(order[0]);
            MenuException.onlyBeverage(order[0]);
            MenuException.notInRangeNumber(order[1]);
        }
    }
}
