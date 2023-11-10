package christmas.launcher;

import christmas.constant.Phrase;
import christmas.controller.DateController;

public class EventPlannerLauncher {
    public void run() {
        System.out.println(Phrase.WELCOME);
        DateController.readDate();
    }
}
