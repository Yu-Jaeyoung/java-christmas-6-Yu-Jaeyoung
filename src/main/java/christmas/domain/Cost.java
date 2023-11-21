package christmas.domain;

import christmas.constant.Menu;
import christmas.view.output.CostView;

import java.util.Map;

public class Cost {
    private final int totalCost;
    private final Order order;

    public Cost(final Order order) {
        this.order = order;
        this.totalCost = initializeTotalCost();
    }

    private int initializeTotalCost() {
        int totalCost = 0;

        for (final Map.Entry<Menu, Integer> menu : order.getOrderHistory().entrySet()) {
            final Menu menuName = menu.getKey();
            final int quantity = menu.getValue();

            totalCost += (menuName.getPrice() * quantity);
        }

        return totalCost;
    }

    public final void orderView() {
        order.orderView();
    }

    public final boolean isFreeGiftTarget() {
        return totalCost >= 120_000;
    }

    public final boolean isEventTarget() {
        return totalCost >= 10_000;
    }

    public final int getMainQuantity() {
        int mainQuantity = 0;

        for (final Map.Entry<Menu, Integer> menu : order.getOrderHistory().entrySet()) {
            if (menu.getKey().getCourse().equals("main")) {
                mainQuantity += menu.getValue();
            }
        }

        return mainQuantity;
    }

    public final int getDessertQuantity() {
        int dessertQuantity = 0;

        for (final Map.Entry<Menu, Integer> menu : order.getOrderHistory().entrySet()) {
            if (menu.getKey().getCourse().equals("dessert")) {
                dessertQuantity += menu.getValue();
            }
        }

        return dessertQuantity;
    }

    public final void totalCostView() {
        CostView.totalCostBeforeDiscount(this.totalCost);
    }

    public final void totalPaymentView(final int totalDiscount) {
        if (isFreeGiftTarget()) {
            CostView.totalCostAfterDiscount(this.totalCost + totalDiscount + 25_000);
            return;
        }
        CostView.totalCostAfterDiscount(this.totalCost + totalDiscount);
    }
}