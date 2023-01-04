package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    @DisplayName("공백 입력 테스트")
    void givenEmptyOrNullString_thenReturnZero(String input){
        int result = calculator.calculate(input);

        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "12"})
    @DisplayName("단일 숫자 입력 테스트")
    void givenOneNum_thenReturnItSelf(String input){
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "!ss", "12a"})
    @DisplayName("비정상적인 수식 테스트")
    void givenOneChar_thenReturnException(String input) {
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @MethodSource("generator")
    @DisplayName("계산 결과 정확성 테스트")
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
