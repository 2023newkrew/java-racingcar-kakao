package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @DisplayName("쉽표(,) 또는 콜론(:)으로 문자열을 분리하여 숫자를 합산할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"'1', 1", "'1,2,32',35", "'1:2:3:4',10", "'1,2:3,4:6', 16"})
    void splitDefaultDelimiter(String text, int expected) {
        int actual = StringCalculator.calculate(text);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("1자 이상의 문자열이 입력되어야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyInput(String text) {
        assertThatThrownBy(() -> StringCalculator.calculate(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("양의 정수(int)만 입력값으로 허용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,2,a", "//@\n1!2!3", "//!\n1!2! ", "//!\n1!!2!3!"})
    void invalidInput(String text){
        assertThatThrownBy(() -> StringCalculator.calculate(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("//와 \n 사이의 문자를 커스텀 구분자로 사용한다.")
    @ParameterizedTest
    @CsvSource(value = {"'//@\n1@2@3', 6", "'//!@\n11!@22!@33', 66"})
    void customDelimiter(String text, int expected){
        int actual = StringCalculator.calculate(text);

        assertThat(actual).isEqualTo(expected);
    }
}
