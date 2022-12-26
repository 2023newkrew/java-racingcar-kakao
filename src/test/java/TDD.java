import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"//;|n1;2;3:6", "//a|n12a34a56:102"}, delimiter = ':')
    public void testMultipleNumberStringWithCustomDelimiter(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

}
