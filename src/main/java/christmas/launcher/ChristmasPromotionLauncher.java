package christmas.launcher;

import christmas.controller.CostController;
import christmas.controller.DateController;
import christmas.controller.DiscountController;
import christmas.controller.EventController;
import christmas.controller.OrderController;
import christmas.util.Read;

public class ChristmasPromotionLauncher {
    static final String WELCOME = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n";
    private final DateController dateController;
    private final OrderController orderController;
    private final CostController costController;
    private final EventController eventController;
    private final DiscountController discountController;

    public ChristmasPromotionLauncher() {
        System.out.printf(WELCOME);
        this.dateController = new DateController(Read.readDate());
        this.orderController = new OrderController(Read.readOrder());
        this.costController = new CostController(orderController.getOrder());
        this.discountController = new DiscountController(dateController.getCalendar());
        this.eventController = new EventController(costController.getCost(),discountController.getDiscountStatus());
    }

    public void run() {
        dateController.getCalendar().eventPreview();
        orderController.getOrder().orderView();
        costController.getCost().totalCostView();
        eventController.freeGiftEventView();
        eventController.eventDiscountApply();
        discountController.discountView();
        discountController.totalDiscountView();
        eventController.totalPaymentView();
        eventController.eventBadgeView();
    }
}
