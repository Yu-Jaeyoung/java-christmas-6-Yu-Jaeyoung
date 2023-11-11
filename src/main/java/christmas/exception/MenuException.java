package christmas.exception;

import christmas.constant.Menu;
import christmas.util.Splitter;
import java.util.HashSet;
import java.util.Set;

public class MenuException extends Exception {
    public static void nothingBeforeComma(final String input) {
        if (input.contains(",") && input.matches("^,.*")) {
            throw new IllegalArgumentException("[ERROR] , 앞에 입력이 없음");
        }
    }

    public static void nothingAfterComma(final String input) {
        if (input.contains(",") && input.matches(".*,$")) {
            throw new IllegalArgumentException("[ERROR] , 뒤에 입력이 없음");
        }
    }

    public static void noHyphen(final String input) {
        if (!input.contains("-")) {
            throw new IllegalArgumentException("[ERROR] 메뉴 개수가 없음");
        }
    }

    public static void noHyphen(final String[] input) {
        for (final String menu : input) {
            if (!menu.contains("-")) {
                System.out.println("[ERROR] 메뉴 개수가 없음");
            }
        }
    }

    public static void nothingBeforeHyphen(final String[] input) {
        for (final String menu : input) {
            if (menu.matches("^-.*")) {
                System.out.println("[ERROR] - 앞에 입력이 없음");
            }
        }
    }

    public static void nothingAfterHyphen(final String[] input) {
        for (final String menu : input) {
            if (menu.matches(".*-$")) {
                throw new IllegalArgumentException("[ERROR] - 뒤에 입력이 없음");
            }
        }
    }

    public static void duplicatedMenu(final String[] input) {
        final Set<String> set = new HashSet<>();

        for (final String menu : input) {
            final String[] order = Splitter.splitWithHyphen(menu);

            if (!set.add(order[0])) {
                throw new IllegalArgumentException("[ERROR] 중복된 메뉴 입력");
            }
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
            throw new IllegalArgumentException("[ERROR] 없는 메뉴");
        }
    }

    public static void notInRangeNumber(final String input) {
        if (!input.matches("([1-9]|1[0-9]|20)")) {
            throw new IllegalArgumentException("[ERROR] - 뒤에 입력이 숫자 1 이상 20 이하가 아님");
        }
    }
}
