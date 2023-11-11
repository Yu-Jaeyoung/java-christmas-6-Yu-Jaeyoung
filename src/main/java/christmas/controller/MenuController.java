package christmas.controller;

import christmas.constant.Menu;
import christmas.domain.Order;
import christmas.validation.MenuValidation;
import christmas.view.ExceptionView;
import christmas.view.InputView;

import java.util.Map;

public class MenuController {
    public static Map<Menu, Integer> readMenus() {
        final String menus = InputView.readMenus();

        try {
            MenuValidation.validate(menus);
            MenuValidation.validateAfterSplitWithComma(menus);
            MenuValidation.validateAfterSplitWithHyphen(menus);
        } catch (IllegalArgumentException illegalArgumentException) {
            ExceptionView.exceptionMessage(illegalArgumentException.getMessage());

            return readMenus();
        }

        return Order.orderHistory(menus);
    }
}
