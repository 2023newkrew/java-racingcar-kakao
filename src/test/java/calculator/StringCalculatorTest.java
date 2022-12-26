package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"'1', 1", "'1,2,32',35", "'1:2:3:4',10", "'1,2:3,4:6', 16"})
    void splitDefaultDelimiter(String text, int expected) {
        int actual = StringCalculator.calculate(text);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyInput(String text) {
        assertThatThrownBy(() -> StringCalculator.calculate(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,2,a", "//@\n1!2!3", "//!\n1!2! ", "//!\n1!!2!3!"})
    void invalidInput(String text){
        assertThatThrownBy(() -> StringCalculator.calculate(text))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"'//@\n1@2@3', 6", "'//!@\n11!@22!@33', 66"})
    void customDelimiter(String text, int expected){
        int actual = StringCalculator.calculate(text);

        assertThat(actual).isEqualTo(expected);
    }
}
