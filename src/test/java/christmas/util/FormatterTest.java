package christmas.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FormatterTest {

    @DisplayName("#,### 형태로 변환")
    @ParameterizedTest
    @ValueSource(ints = {120000, 2220000, 55000})
    void decimalFormatter(final int cost) {
        String result = Formatter.decimalFormatter(cost);

        assertThat(result).isEqualTo(String.format("%,d", cost));
    }
}