package christmas.util;

import christmas.validation.DateValidation;
import christmas.validation.OrderValidation;
import christmas.view.ExceptionView;
import christmas.view.InputView;

public class Read {
    public static int readDate(String date) {
        try {
            DateValidation.validate(date);
        } catch (IllegalArgumentException illegalArgumentException) {
            ExceptionView.exceptionMessage(illegalArgumentException.getMessage());

            return readDate(InputView.readDate());
        }

        return Parser.stringToInt(date);
    }

    public static String readOrder(String order) {
        try {
            OrderValidation.validate(order);
            OrderValidation.validateAfterSplitWithComma(order);
            OrderValidation.validateAfterSplitWithHyphen(order);
        } catch (IllegalArgumentException illegalArgumentException) {
            ExceptionView.exceptionMessage(illegalArgumentException.getMessage());

            return readOrder(InputView.readOrder());
        }

        return order;
    }
}
