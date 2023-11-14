package christmas.launcher;

import christmas.controller.CostController;
import christmas.controller.DateController;
import christmas.controller.DiscountController;
import christmas.controller.EventController;
import christmas.controller.OrderController;
import christmas.util.Read;
import christmas.view.InputView;

public class ChristmasPromotionLauncher {
    static final String WELCOME = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n";
    private final EventController eventController;
    private final DiscountController discountController;

    public ChristmasPromotionLauncher() {
        System.out.printf(WELCOME);
        final DateController dateController = new DateController(Read.readDate(InputView.readDate()));
        final OrderController orderController = new OrderController(Read.readOrder(InputView.readOrder()));
        final CostController costController = new CostController(orderController.getOrder());
        this.discountController = new DiscountController(dateController.getCalendar());
        this.eventController = new EventController(costController.getCost(), discountController.getDiscountStatus());
    }

    public void run() {
        discountController.eventPreview();
        eventController.eventView();
        eventController.freeGiftEventView();
        eventController.eventDiscountApply();
        discountController.discountView();
        discountController.totalDiscountView();
        eventController.totalPaymentView();
        eventController.eventBadgeView();
    }
}
