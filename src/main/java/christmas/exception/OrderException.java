package christmas.exception;

import christmas.constant.Menu;
import christmas.util.Splitter;

import java.util.HashSet;
import java.util.Set;

public class OrderException {
    static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void blank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void containsBlank(final String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void nothingBeforeComma(final String input) {
        if (input.contains(",") && input.matches("^,.*")) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void nothingAfterComma(final String input) {
        if (input.contains(",") && input.matches(".*,$")) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void noHyphen(final String input) {
        if (!input.contains("-")) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void noHyphen(final String[] input) {
        for (final String menu : input) {
            if (!menu.contains("-")) {
                System.out.println(INVALID_ORDER);
            }
        }
    }

    public static void nothingBeforeHyphen(final String[] input) {
        for (final String menu : input) {
            if (menu.matches("^-.*")) {
                System.out.println(INVALID_ORDER);
            }
        }
    }

    public static void nothingAfterHyphen(final String[] input) {
        for (final String menu : input) {
            if (menu.matches(".*-$")) {
                throw new IllegalArgumentException(INVALID_ORDER);
            }
        }
    }

    public static void duplicatedMenu(final String[] input) {
        final Set<String> set = new HashSet<>();

        for (final String menu : input) {
            final String[] order = Splitter.splitWithHyphen(menu);

            if (!set.add(order[0])) {
                throw new IllegalArgumentException(INVALID_ORDER);
            }
        }
    }

    public static void onlyBeverage(final String[] input) {
        boolean found = false;

        for (final String menu : input) {
            final String[] order = Splitter.splitWithHyphen(menu);
            if (!order[0].equals("beverage")) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void notInMenu(final String input) {
        boolean found = false;

        for (final Menu menu : Menu.values()) {
            if (menu.getMenuName().equals(input)) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void notInRangeNumber(final String input) {
        if (!input.matches("([1-9]|1[0-9]|20)")) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public static void menuCountOver(final int count) {
        if (count > 20) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
}
