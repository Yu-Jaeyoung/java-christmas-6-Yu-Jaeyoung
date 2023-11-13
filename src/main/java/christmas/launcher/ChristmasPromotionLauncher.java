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
        this.eventController = new EventController(dateController.getCalendar(), costController.getCost());
        this.discountController = new DiscountController();
    }

    public void run() {
        dateController.getCalendar().eventPreview();
        orderController.getOrder().orderView();
        costController.getCost().totalCostView();
        // isEventTarget 아니면, 실행할 필요 없음. 해당 메소드는 Cost 클래스에 존재
        eventController.getEvent()
                .weekendOrDayDiscount(discountController.getDiscountStatus(), orderController.getOrder());
        eventController.getEvent().specialDiscount(discountController.getDiscountStatus());
        eventController.getEvent().christmasDiscount(discountController.getDiscountStatus());
        eventController.getEvent().freeGiftDiscount(discountController.getDiscountStatus());
        eventController.getEvent().freeGiftEventView();
        discountController.discountView();
        discountController.totalDiscountView();
        costController.getCost().totalPayment(discountController.getDiscountStatus().getTotalDiscount());
        eventController.getEvent().eventBadgeView(discountController.getDiscountStatus());
    }
}
