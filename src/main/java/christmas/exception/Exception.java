package christmas.exception;

public class Exception {
    public static void blank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력이 없음");
        }
    }

    public static void containsBlank(final String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 공백이 포함된 입력");
        }
    }
}
