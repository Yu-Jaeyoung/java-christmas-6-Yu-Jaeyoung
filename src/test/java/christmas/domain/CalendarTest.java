package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalendarTest {

    private final Calendar weekend = new Calendar(2);
    private final Calendar starDay = new Calendar(31);
    private final Calendar christmasDDay = new Calendar(23);

    @DisplayName("Calendar 클래스의 멤버변수 date 값이 주말인 경우 true를 반환")
    @Test
    void isWeekend() {
        assertTrue(weekend.isWeekend());
    }

    @DisplayName("Calendar 클래스의 멤버변수 date 값이 평일인 경우 false를 반환")
    @Test
    void isNotWeekend() {
        assertFalse(starDay.isWeekend());
    }

    @DisplayName("Calendar 클래스의 멤버변수 date 값이 starDay인 경우 true를 반환")
    @Test
    void isStarDay() {
        assertTrue(starDay.isStarDay());
    }

    @DisplayName("Calendar 클래스의 멤버변수 date 값이 starDay가 아닌 경우 false를 반환")
    @Test
    void isNotStarDay() {
        assertFalse(christmasDDay.isStarDay());
    }

    @DisplayName("Calendar 클래스의 멤버변수 date 값이 크리스마스 D-Day인 경우 0이 아닌 수(this.date)를 반환")
    @Test
    void isChristmasDDay() {
        assertThat(christmasDDay.christmasDDay()).isNotZero();
    }

    @DisplayName("Calendar 클래스의 멤버변수 date 값이 크리스마스 D-Day가 아닌 경우 0을 반환")
    @Test
    void isNotChristmasDDay() {
        assertThat(starDay.christmasDDay()).isZero();
    }
}