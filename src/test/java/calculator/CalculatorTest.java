package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    void givenEmptyOrNullString_thenReturnZero(String input){
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void givenOneDigitNum_thenReturnItSelf(String input){
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "!"})
    void givenOneChar_thenReturnException(String input) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(1);
    }
}
