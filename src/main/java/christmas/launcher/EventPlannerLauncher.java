package christmas.launcher;

import christmas.constant.Menu;
import christmas.constant.Phrase;
import christmas.controller.DateController;
import christmas.controller.MenuController;
import christmas.domain.Cost;
import christmas.view.OutputView;

import java.util.Map;

public class EventPlannerLauncher {
    public void run() {
        System.out.println(Phrase.WELCOME);
        DateController.readDate();
        final Map<Menu, Integer> OrderHistory = MenuController.readMenus();

        OutputView.orderMenu(OrderHistory);
        OutputView.totalCostBeforeDiscount(Cost.totalCost(OrderHistory));
    }
}
