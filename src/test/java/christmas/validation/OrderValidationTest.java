package christmas.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderValidationTest {
    static final String INVALID_ORDER = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    @DisplayName("빈 공백 입력 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", " 제로콜라-1", "제 로콜라-1", "제로 콜라-1", "제로콜라 -1", " 제로 콜라 -1"})
    void blankAndNotANumberException(String input) {
        assertThatThrownBy(() -> OrderValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 공백 및 숫자가 아닌 입력 예외 처리 시 출력 메시지")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", " 제로콜라-1", "제 로콜라-1", "제로 콜라-1", "제로콜라 -1", " 제로 콜라 -1"})
    void blankAndNotANumberExceptionMessage(String input) {
        assertThatThrownBy(() -> OrderValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @DisplayName(" , 앞 혹은 뒤에 아무 것도 없는 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,", ",제로콜라-1", ","})
    void nothingBeforeAndAfterComma(String input) {
        assertThatThrownBy(() -> OrderValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(" , 앞 혹은 뒤에 아무 것도 없는 경우 예외 처리 시 출력 메시지")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,", ",제로콜라-1", ","})
    void nothingBeforeAndAfterCommaMessage(String input) {
        assertThatThrownBy(() -> OrderValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @DisplayName(" - 없는 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라1"})
    void noHyphen(String input) {
        assertThatThrownBy(() -> OrderValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(" - 없는 경우 예외 처리 시 출력 메시지")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라1"})
    void noHyphenMessage(String input) {
        assertThatThrownBy(() -> OrderValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @DisplayName(" , 로 분리된 뒤 - 없는 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,타파스1", "제로콜라-1,타파스-1,레드와인1"})
    void noHyphenAfterSplitWithComma(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(" , 로 분리된 뒤 - 없는 경우 예외 처리 시 출력 메시지")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,타파스1", "제로콜라-1,타파스-1,레드와인1"})
    void noHyphenAfterSplitWithCommaMessage(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @DisplayName(" - 앞 혹은 뒤에 아무 것도 없는 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,타파스-", "타파스-1,-1"})
    void nothingBeforeAndAfterHyphen(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(" - 앞 혹은 뒤에 아무 것도 없는 경우 예외 처리 시 출력 메시지")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,타파스-", "타파스-1,-1"})
    void nothingBeforeAndAfterHyphenMessage(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithComma(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @DisplayName("중복된 메뉴 주문 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"시저샐러드-1,시저샐러드-1", "타파스-1,타파스-1", "타파스-1,바비큐립-1,타파스-1"})
    void duplicatedMenu(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 메뉴 주문 시 예외 처리 시 출력 메시지")
    @ParameterizedTest
    @ValueSource(strings = {"시저샐러드-1,시저샐러드-1", "타파스-1,타파스-1", "타파스-1,바비큐립-1,타파스-1"})
    void duplicatedMenuMessage(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @DisplayName("음료만 주문 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,제로콜라-1", "레드와인-1,레드와인-1", "레드와인-1,제로콜라-1,레드와인-1"})
    void onlyBeverage(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문 시 예외 처리 시 출력 메시지")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,제로콜라-1", "레드와인-1,레드와인-1", "레드와인-1,제로콜라-1,레드와인-1"})
    void onlyBeverageMessage(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @DisplayName("메뉴에 없는 것 주문 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"환타-1", "바비큐립-1,우테코합격실패주-3", "타파스-1,만두-2,시저샐러드-1"})
    void notInMenu(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴에 없는 것 주문 시 예외 처리 시 출력 메시지")
    @ParameterizedTest
    @ValueSource(strings = {"환타-1", "바비큐립-1,우테코합격실패주-3", "타파스-1,만두-2,시저샐러드-1"})
    void notInMenuMessage(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @DisplayName("숫자가 범위 내가 아닌 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"바비큐립-21", "바비큐립-1,티본스테이크-30", "시저샐러드-1,타파스-2,바비큐립-25"})
    void notInRangeNumber(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 범위 내가 아닌 경우 에러 발생 시 출력 메시지")
    @ParameterizedTest
    @ValueSource(strings = {"바비큐립-21", "바비큐립-1,티본스테이크-30", "시저샐러드-1,타파스-2,바비큐립-25"})
    void notInRangeNumberMessage(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @DisplayName("메뉴의 개수 합이 20개가 넘으면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"바비큐립-15,타파스-6", "레드와인-1,제로콜라-17,바비큐립-3"})
    void menuCountOver(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수 합이 20개가 넘으면 에러 발생 시 출력 메시지")
    @ParameterizedTest
    @ValueSource(strings = {"바비큐립-15,타파스-6", "레드와인-1,제로콜라-17,바비큐립-3"})
    void menuCountOverMessage(String input) {
        assertThatThrownBy(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-2,레드와인-1,초코케이크-1", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", "타파스-1,제로콜라-1"})
    @DisplayName("정상적인 메뉴 입력 테스트")
    void validDateException(String input) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThatCode(() -> OrderValidation.validate(input)).doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> OrderValidation.validateAfterSplitWithComma(input))
                .doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> OrderValidation.validateAfterSplitWithHyphen(input))
                .doesNotThrowAnyException();
    }
}