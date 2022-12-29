package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"-1", "a", "!"})
    @DisplayName("음수 혹은 문자가 포함될 경우 예외 발생")
    void negativeNumThrowExceptionTest(String input) {
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0부터 9 사이의 수만 입력할 수 있습니다.");
    }
}
