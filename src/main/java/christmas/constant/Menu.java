package christmas.constant;

public enum Menu {
    BUTTON_MUSHROOM_SOUP("양송이수프", 6000, "appetizer"),
    TAPAS("타파스", 5500, "appetizer"),
    CAESAR_SALAD("시저샐러드", 8000, "appetizer"),
    T_BONE_STEAK("티본스테이크", 55000, "main"),
    BARBECUE_RIBS("바비큐립", 54000, "main"),
    SEAFOOD_PASTA("해산물파스타", 35000, "main"),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, "main"),
    CHOCOLATE_CAKE("초코케이크", 15000, "dessert"),
    ICE_CREAM("아이스크림", 5000, "dessert"),
    ZERO_COKE("제로콜라", 3000, "beverage"),
    RED_WINE("레드와인", 60000, "beverage"),
    CHAMPAGNE("샴페인", 25000, "beverage");

    private final String menuName;
    private final int price;
    private final String course;

    Menu(final String menuName, final int price, final String course) {
        this.menuName = menuName;
        this.price = price;
        this.course = course;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public String getCourse() {
        return course;
    }
}
