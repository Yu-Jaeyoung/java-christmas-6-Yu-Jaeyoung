package christmas.controller;

import christmas.constant.Discount;
import christmas.domain.DiscountStatus;
import christmas.util.Formatter;
import christmas.view.output.DiscountView;

public class DiscountController {
    static final String Benefit = "\n<혜택 내역>\n";
    static final String NOTHING = "없음\n";
    static final String BENEFIT_COST = "\n<총혜택 금액>";
    private final DiscountStatus discountStatus;

    public DiscountController() {
        this.discountStatus = new DiscountStatus();
    }

    public final DiscountStatus getDiscountStatus() {
        return discountStatus;
    }

    public final void discountView() {
        System.out.printf(Benefit);
        if (discountStatus.getTotalDiscount() != 0) {
            for (Discount discount : Discount.values()) {
                DiscountView.discountView(discount, discountStatus.getDiscount(discount));
            }
            return;
        }
        System.out.printf(NOTHING);
    }

    public final void totalDiscountView() {
        System.out.printf("%s\n%s원\n", BENEFIT_COST, Formatter.decimalFormatter(discountStatus.getTotalDiscount()));
    }
}
