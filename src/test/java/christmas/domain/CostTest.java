package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CostTest {

    private Cost costWithDessert;
    private Cost costWithMain;
    private final Order firstOrder = new Order("제로콜라-1,아이스크림-1");
    private final Order secondOrder = new Order("해산물파스타-5");

    @BeforeEach
    void setCost() {
        costWithDessert = new Cost(firstOrder);
        costWithMain = new Cost(secondOrder);
    }

    @DisplayName("12만원 이상 구매 고객은 증정 이벤트 대상")
    @Test
    void isFreeGiftTarget() {
        assertTrue(costWithMain.isFreeGiftTarget());
    }

    @DisplayName("12만원 미만 구매 고객은 증정 이벤트 대상이 아님")
    @Test
    void isNotFreeGiftTarget() {
        assertFalse(costWithDessert.isFreeGiftTarget());
    }

    @DisplayName("1만원 이상 구매 고객은 이벤트 대상")
    @Test
    void isEventTarget() {
        assertTrue(costWithMain.isFreeGiftTarget());
    }

    @DisplayName("1만원 미만 구매 고객은 이벤트 대상이 아님")
    @Test
    void isNotEventTarget() {
        assertFalse(costWithDessert.isFreeGiftTarget());
    }

    @DisplayName("Main 메뉴의 개수를 반환")
    @Test
    void getMainQuantity() {
        assertThat(costWithMain.getMainQuantity()).isEqualTo(5);
    }

    @DisplayName("Dessert의 개수를 반환")
    @Test
    void getDessertQuantity() {
        assertThat(costWithDessert.getDessertQuantity()).isEqualTo(1);
    }
}