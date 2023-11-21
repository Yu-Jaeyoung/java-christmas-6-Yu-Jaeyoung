package christmas.exception;

public class DateException {
    static final String INVALID_DAY = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public static void blank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_DAY);
        }
    }

    public static void containsBlank(final String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(INVALID_DAY);
        }
    }

    public static void notANumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INVALID_DAY);
        }
    }

    public static void notInRange(final String input) {
        final int number = Integer.parseInt(input);

        if (number < 1) {
            throw new IllegalArgumentException(INVALID_DAY);
        }

        if (number > 31) {
            throw new IllegalArgumentException(INVALID_DAY);
        }
    }
}
