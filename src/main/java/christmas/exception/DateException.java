package christmas.exception;

public class DateException extends Exception{
    public static void notANumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자 외 입력");
        }
    }

    public static void notInRange(final String input) {
        final int number = Integer.parseInt(input);

        if (number < 1) {
            throw new IllegalArgumentException("[ERROR] 1보다 작은 입력");
        }

        if (number > 31) {
            throw new IllegalArgumentException("[ERROR] 31보다 큰 입력");
        }
    }
}
