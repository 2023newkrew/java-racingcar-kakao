package calculator;

import calculator.domain.Formula;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @NullAndEmptySource
    @ParameterizedTest
    void nullTest(String input) {
        Formula formula = new Formula(input);
        assertThat(formula.calculate()).isEqualTo(0);
    }

    @Test
    void oneNumberTest() {
        Formula formula = new Formula("1");
        assertThat(formula.calculate()).isEqualTo(1);
    }

    @Test
    void commaTest() {
        Formula formula = new Formula("1,2");
        assertThat(formula.calculate()).isEqualTo(3);
    }

    @Test
    void colonTest() {
        Formula formula = new Formula("1:2");
        assertThat(formula.calculate()).isEqualTo(3);
    }

    @Test
    void commaColonTest() {
        Formula formula = new Formula("1,2:3");
        assertThat(formula.calculate()).isEqualTo(6);
    }

    @Test
    void customDelimiterTest() {
        Formula formula = new Formula("//;\n1;2");
        assertThat(formula.calculate()).isEqualTo(3);
    }

    @Test
    void allDelimiterTest() {
        Formula formula = new Formula("//A\n1,2:3A4");
        assertThat(formula.calculate()).isEqualTo(10);
    }

    @ValueSource(strings = {"2.3", "ab9", "1e9"})
    @ParameterizedTest
    void inputTypeExceptionTest(String input) {
        Formula formula = new Formula(input);
        assertThatThrownBy(formula::calculate)
                .isInstanceOf(RuntimeException.class);
    }

    @ValueSource(strings = {"-3", "-7:124", "//;\n1;2:-3"})
    @ParameterizedTest
    void inputRangeExceptionTest(String input) {
        Formula formula = new Formula(input);
        assertThatThrownBy(formula::calculate)
                .isInstanceOf(RuntimeException.class);
    }
}
