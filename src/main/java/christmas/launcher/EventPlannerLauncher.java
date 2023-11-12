package christmas.launcher;

import christmas.constant.Phrase;
import christmas.controller.DateController;
import christmas.controller.EventController;
import christmas.controller.MenuController;

public class EventPlannerLauncher {
    public EventPlannerLauncher() {
        System.out.println(Phrase.WELCOME);
    }

    public void run() {
        EventController.checkEvent(DateController.readDate(), MenuController.readMenus());
    }
}
