package christmas.launcher;

import christmas.constant.Phrase;
import christmas.controller.DateController;
import christmas.controller.MenuController;
import christmas.view.OutputView;

public class EventPlannerLauncher {
    public void run() {
        System.out.println(Phrase.WELCOME);
        DateController.readDate();
        OutputView.orderMenu(MenuController.readMenus());
    }
}
