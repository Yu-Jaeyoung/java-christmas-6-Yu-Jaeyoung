package christmas.constant;

public enum Discount {
    CHRISTMAS("크리스마스 디데이 할인: ", 1_000),
    WEEKEND("주말 할인: ", 2_023),
    WEEKDAY("평일 할인: ", 2_023),
    SPECIAL("특별 할인: ", 1_000),
    FREE_GIFT("증정 이벤트: ", 25_000);

    Discount(final String discountPhrase, final int discountValue) {
        this.discountPhrase = discountPhrase;
        this.discountValue = discountValue;
    }

    private final String discountPhrase;
    private final int discountValue;

    public String getDiscountPhrase() {
        return discountPhrase;
    }

    public final int getDiscountValue() {
        return discountValue;
    }
}
