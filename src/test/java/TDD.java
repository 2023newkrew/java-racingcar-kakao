import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TDD {
    private final Calculator calculator = new Calculator();
    @Test
    public void testEmptyString() {
        int result = calculator.calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testNullString() {
        int result = calculator.calculate(null);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "123:123"}, delimiter = ':')
    public void testSingleNumberString(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "12,34,56:102"}, delimiter = ':')
    public void testMultipleNumberStringWithComma(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2;3:6", "12,34;56:102"}, delimiter = ':')
    public void testMultipleNumberStringWithCommaAndColon(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testMultipleNumberStringWithCustomDelimiter() {
        int result = calculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testMultipleNumberStringWithCustomDelimiter2() {
        int result = calculator.calculate("//a\n12a34a56");
        assertThat(result).isEqualTo(102);
    }

    @ParameterizedTest
    @ValueSource(strings = {";;", "1,-2,3", "1,,3", "1,a,b", "a,b;c", "1, 2, 3", "1,  ,3"})
    public void testInvalidNumberString(String input) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calculator.calculate(input)).withMessage("잘못된 숫자가 입력되었습니다.");
    }
}
