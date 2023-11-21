package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    private static final String stringOrder = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
    final Order order = new Order(stringOrder);

    @DisplayName("Map 형태로 stringOrder를 변환하여 저장")
    @Test
    void getOrderHistory() {
        assertThat(order.getOrderHistory())
                .containsEntry(Menu.T_BONE_STEAK, 1)
                .containsEntry(Menu.BARBECUE_RIBS, 1)
                .containsEntry(Menu.CHOCOLATE_CAKE, 2)
                .containsEntry(Menu.ZERO_COKE, 1);
    }
}