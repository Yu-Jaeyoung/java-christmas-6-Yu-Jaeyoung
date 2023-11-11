package christmas.util;

import christmas.constant.Menu;

public class Parser {
    public static int stringToInt(final String string) {
        return Integer.parseInt(string);
    }

    public static Menu stringToMenu(final String string) {
        for (final Menu menu : Menu.values()) {
            if (menu.getMenuName().equals(string)) {
                return menu;
            }
        }
        return null;
    }
}
