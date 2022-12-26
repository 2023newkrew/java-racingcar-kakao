import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(new StringUtil());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void emptyOrNullString(String input) {
        assertThatCalcResultEqualTo(input, 0);
    }

    @Test
    void oneNumber() {
        String input = "1";
        assertThatCalcResultEqualTo(input, 1);
    }

    @Test
    void sumOfComma() {
        String input = "1,2";
        assertThatCalcResultEqualTo(input, 3);
    }

    @Test
    void sumOfCommaOrSemiColon() {
        String input = "1,2;3";
        assertThatCalcResultEqualTo(input, 6);
    }

    @Test
    void customDelimiter() {
        String input = "//ab\n1ab2,4";
        assertThatCalcResultEqualTo(input, 7);
    }

    void assertThatCalcResultEqualTo(String input, Integer expected) {
        Integer result = calculator.calc(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
