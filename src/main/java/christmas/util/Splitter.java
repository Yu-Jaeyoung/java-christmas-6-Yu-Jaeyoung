package christmas.util;

public class Splitter {
    public static String[] splitWithComma(final String input) {
        return input.split(",");
    }

    public static String[] splitWithHyphen(final String input) {
        return input.split("-");
    }
}
