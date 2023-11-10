package christmas.controller;

import christmas.validation.MenuValidation;
import christmas.view.ExceptionView;
import christmas.view.InputView;

public class MenuController {
    public static String readMenus() {
        final String menus = InputView.readMenus();

        try {
            MenuValidation.validate(menus);
            MenuValidation.validateAfterSplitWithComma(menus);
            MenuValidation.validateAfterSplitWithHyphen(menus);
        } catch (IllegalArgumentException illegalArgumentException) {
            ExceptionView.exceptionMessage(illegalArgumentException.getMessage());

            return readMenus();
        }

        return menus;
    }
}
