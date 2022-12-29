package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @DisplayName("기본적으로 콤마 또는 콜론을 사용해 문자열을 분리하여 합산한다.")
    @ParameterizedTest
    @CsvSource(value = {"'1', 1", "'1,2,32',35", "'1:2:3:4',10", "'1,2:3,4:6', 16"})
    void splitDefaultDelimiter(String text, int expected) {
        int actual = StringCalculator.calculate(text);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("문자열은 null 또는 빈 문자열일 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyInput(String text) {
        assertThatThrownBy(() -> StringCalculator.calculate(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열은 양의 정수만 입력이 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,2,a", "1,,2,3", "1,2, "})
    void notPositiveInput(String text) {
        assertThatThrownBy(() -> StringCalculator.calculate(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지정한 사용자 정의 구분자만 사용가능하다.")
    @Test
    void invalidDelimiterInput() {
        assertThatThrownBy(() -> StringCalculator.calculate("//@\n1!2!3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 정의 구분자로 문자열을 분리하고 합산한다.")
    @ParameterizedTest
    @CsvSource(value = {"'//@\n1@2@3', 6", "'//!@\n11!@22!@33', 66"})
    void customDelimiter(String text, int expected) {
        int actual = StringCalculator.calculate(text);

        assertThat(actual).isEqualTo(expected);
    }
}
