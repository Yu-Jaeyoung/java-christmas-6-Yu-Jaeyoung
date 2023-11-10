package christmas.controller;

import christmas.util.Parser;
import christmas.validation.DateValidation;
import christmas.view.ExceptionView;
import christmas.view.InputView;

public class DateController {
    public static int readDate() {
        final String date = InputView.readDate();

        try {
            DateValidation.validate(date);
        } catch (IllegalArgumentException illegalArgumentException) {
            ExceptionView.exceptionMessage(illegalArgumentException.getMessage());

            return readDate();
        }

        return Parser.stringToInt(date);
    }

}
