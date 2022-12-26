package calculator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    void givenEmptyOrNullString_thenReturnZero(String input){
        Calculator calculator = new Calculator();
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(0);
    }
}
