package christmas.constant;

public enum Discount {
    CHRISTMAS(1_000),
    WEEKEND(2_023),
    WEEKDAY(2_023),
    SPECIAL(1_000),
    FREE_GIFT(25_000);

    Discount(final int discountValue) {
        this.discountValue = discountValue;
    }

    private final int discountValue;

    public final int getDiscountValue() {
        return discountValue;
    }
}
