package christmas.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constant.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @DisplayName("String 입력을 Integer 형태로 변환 후 반환")
    @ParameterizedTest
    @CsvSource({"123, 123", "-456, -456", "0, 0"})
    void validStringToInt(final String input, final int expected) {
        final int result = Parser.stringToInt(input);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("Integer로 변환할 수 없는 입력은 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.23", "가나다"})
    void invalidStringToInt(final String input) {
        assertThatThrownBy(() -> Parser.stringToInt(input)).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("올바른 String 형태의 메뉴 입력은 Menu의 값을 반환")
    @ParameterizedTest
    @CsvSource({"양송이수프, BUTTON_MUSHROOM_SOUP", "타파스, TAPAS", "시저샐러드, CAESAR_SALAD",
            "티본스테이크, T_BONE_STEAK", "바비큐립, BARBECUE_RIBS", "해산물파스타, SEAFOOD_PASTA",
            "크리스마스파스타, CHRISTMAS_PASTA", "초코케이크, CHOCOLATE_CAKE", "아이스크림, ICE_CREAM",
            "레드와인, RED_WINE", "샴페인, CHAMPAGNE"})
    void validMenuName(final String input, final String expected) {
        Menu result = Parser.stringToMenu(input);
        Menu expectedMenu = Menu.valueOf(expected);
        assertThat(result).isEqualTo(expectedMenu);
    }

    @DisplayName("없는 메뉴 입력은 null을 반환")
    @ParameterizedTest
    @ValueSource(strings = {"자장면", "탕수육", "떡볶이"})
    void invalidMenuName(final String input) {
        Menu result = Parser.stringToMenu(input);
        assertThat(result).isEqualTo(null);
    }
}