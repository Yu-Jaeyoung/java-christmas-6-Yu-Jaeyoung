package christmas.validation;

import christmas.exception.Exception;

public class DateValidation {
    public static void validate(final String input) {
        Exception.blank(input);
        Exception.containsBlank(input);
        Exception.notANumber(input);
        Exception.notInRange(input);
    }
}
