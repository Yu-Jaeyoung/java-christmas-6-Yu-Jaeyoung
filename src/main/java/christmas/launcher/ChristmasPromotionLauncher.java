package christmas.launcher;

import christmas.constant.Phrase;
import christmas.controller.CostController;
import christmas.controller.DateController;
import christmas.controller.DiscountController;
import christmas.controller.EventController;
import christmas.controller.OrderController;
import christmas.util.Read;

public class ChristmasPromotionLauncher {
    public ChristmasPromotionLauncher() {
        System.out.println(Phrase.WELCOME);
    }

    public void run() {
        DateController dateController = new DateController(Read.readDate());
        OrderController orderController = new OrderController(Read.readOrder());
        CostController costController = new CostController(orderController.getOrder());
        EventController eventController = new EventController(dateController.getCalendar(), costController.getCost());
        DiscountController discountController = new DiscountController(orderController.getOrder());
    }
}
