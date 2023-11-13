package christmas.domain;

import christmas.constant.Menu;
import christmas.view.output.CostView;

import java.util.Map;

public class Cost {
    private final int totalCost;

    public Cost(final Order order) {
        this.totalCost = initializeTotalCost(order);
    }

    private int initializeTotalCost(final Order order) {
        int totalCost = 0;

        for (final Map.Entry<Menu, Integer> menu : order.getOrderHistory().entrySet()) {
            final Menu menuName = menu.getKey();
            final int quantity = menu.getValue();

            totalCost += (menuName.getPrice() * quantity);
        }

        return totalCost;
    }

    public final boolean isFreeGiftTarget() {
        return totalCost >= 120_000;
    }

    public final boolean isEventTarget() {
        return totalCost >= 10_000;
    }

    public final void totalCostView() {
        CostView.totalCostBeforeDiscount(this.totalCost);
    }

    public final void totalPayment(final int totalDiscount) {
        if (isFreeGiftTarget()) {
            CostView.totalCostAfterDiscount(this.totalCost + totalDiscount + 25_000);
            return;
        }
        CostView.totalCostAfterDiscount(this.totalCost + totalDiscount);
    }
}