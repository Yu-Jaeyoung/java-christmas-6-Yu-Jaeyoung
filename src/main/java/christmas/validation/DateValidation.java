package christmas.validation;

import christmas.exception.DateException;

public class DateValidation {
    public static void validate(final String input) {
        DateException.blank(input);
        DateException.containsBlank(input);
        DateException.notANumber(input);
        DateException.notInRange(input);
    }
}
