package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("generator")
    void givenExpressionString_thenReturnSum(String input, Integer expected){
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> generator(){
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("2;3,4", 9)
        );
    }

}
