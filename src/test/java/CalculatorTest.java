import Calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.regex.Matcher;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    void checkEmptyText() {
        Calculator calculator = new Calculator("");

        assertThat(calculator.isEmptyOrNull()).isEqualTo(true);
    }

    @Test
    void checkNullText() {
        Calculator calculator = new Calculator(null);

        assertThat(calculator.isEmptyOrNull()).isEqualTo(true);
    }

    @Test
    void singleNoText() {
        Calculator calculator = new Calculator("1");

        assertThat(calculator.run()).isEqualTo(1);
    }

    @Test
    void checkSplitTextWithComma() {
        Calculator calculator = new Calculator("1,2");

        calculator.splitText();
        assertThat(calculator.numbers).isEqualTo(Arrays.asList(1, 2));
    }

    @Test
    void checkSplitTextWithColon() {
        Calculator calculator = new Calculator("1:2:3");

        calculator.splitText();
        assertThat(calculator.numbers).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void checkSplitTextWithCommaAndColon() {
        Calculator calculator = new Calculator("1,2:3");

        calculator.splitText();
        assertThat(calculator.numbers).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-2:3", "1, 2:3", "1,,2"})
    void checkSplitInvalidTextWithDelimiter(String text) {
        Calculator calculator = new Calculator(text);

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calculator.splitText());
    }

    @Test
    void getIfCustomDelimiterExist() {
        Calculator calculator = new Calculator("//;\n1;2;3");

        assertThat(calculator.checkCustomDelimiter()).isInstanceOf(Matcher.class);
    }

    @Test
    void getNullIfCustomDelimiterNotExist() {
        Calculator calculator = new Calculator("1;2;3");

        assertThat(calculator.checkCustomDelimiter()).isNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {";", "!", "$"})
    void buildDelimiters(String customDelimiter) {
        assertThat(Calculator.buildDelimiters(customDelimiter)).isEqualTo("[,:" + customDelimiter + "]");
    }

    @Test
    void testAddIntegerElements() {
        Calculator calculator = new Calculator("1,2,3");

        calculator.splitText();
        assertThat(calculator.addIntegerElements()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2:3"})
    void testValidRunWithResult6(String text) {
        Calculator calculator = new Calculator(text);

        assertThat(calculator.run()).isEqualTo(6);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "0,0,0"})
    void testValidRunWithResult0(String text) {
        Calculator calculator = new Calculator(text);

        assertThat(calculator.run()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-2,3", "1,,2", "1,2!3", "1, 2,3", ".", "-1", "-2", ";", "!", "1//!\n2!3"})
    void testInvalidRun(String text) {
        Calculator calculator = new Calculator(text);

        assertThatRuntimeException().isThrownBy(calculator::run);
    }
}
