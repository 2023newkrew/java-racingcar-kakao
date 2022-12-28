package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumbersInStringAddCalculatorTest {
    @Test
    void nullTest() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator(null);
        assertThat(calculator.calculate()).isEqualTo(0);
    }

    @Test
    void emptyTest() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("");
        assertThat(calculator.calculate()).isEqualTo(0);
    }

    @Test
    void oneNumberTest() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("1");
        assertThat(calculator.calculate()).isEqualTo(1);
    }
    @Test
    void commaTest() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("1,2");
        assertThat(calculator.calculate()).isEqualTo(3);
    }

    @Test
    void colonTest() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("1:2");
        assertThat(calculator.calculate()).isEqualTo(3);
    }

    @Test
    void commaColonTest() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("1,2:3");
        assertThat(calculator.calculate()).isEqualTo(6);
    }

    @Test
    void customDelimiterTest() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("//;\n1;2");
        assertThat(calculator.calculate()).isEqualTo(3);
    }

    @Test
    void allDelimiterTest() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("//A\n1,2:3A4");
        assertThat(calculator.calculate()).isEqualTo(10);
    }

    @ValueSource(strings = {"2.3", "ab9", "1e9"})
    @ParameterizedTest
    void inputTypeExceptionTest(String input) {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator(input);
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(RuntimeException.class);
    }

    @ValueSource(strings = {"-3", "-7:124", "//;\n1;2:-3"})
    @ParameterizedTest
    void inputRangeExceptionTest(String input) {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator(input);
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(RuntimeException.class);
    }
}
