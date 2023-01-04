package calculator;

import calculator.domain.calculator.Calculator;
import calculator.domain.calculator.prompt.Prompt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import racing.domain.car.Car;
import racing.domain.car.Cars;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @NullAndEmptySource
    public void calculateEmpty(String input) {
        assertThat(calculator.calculate(new Prompt(input))).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ValueSource(strings = {"1", "24"})
    public void calculateSingleNumber(String input) {
        assertThat(calculator.calculate(new Prompt(input))).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @DisplayName("기본 구분자(, :)로 구분된 숫자의 합을 반환한다.")
    @CsvSource(value = {"1,4?5", "1:2:3?6", "1:5,9?15"}, delimiter = '?')
    public void calculateNumberWithDefaultDelimiter(String input, int expected) {
        assertThat(calculator.calculate(new Prompt(input))).isEqualTo(expected );
    }

    @ParameterizedTest
    @MethodSource(value = "calculateNumberWithCustomDelimiterArgument")
    @DisplayName("커스텀 구분자가 지정되었을 경우 구분자에 추가하여 합을 반환한다.")
    public void calculateNumberWithCustomDelimiter(String input, int expected) {
        assertThat(calculator.calculate(new Prompt(input))).isEqualTo(expected);
    }

    @Test
    @DisplayName("음수가 포함된 식을 계산하려 할 경우 RuntimeException이 발생한다.")
    public void isExistNegativeNumber() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                calculator.calculate(new Prompt("-1:2:3"));
            });
    }

    static Stream<Arguments> calculateNumberWithCustomDelimiterArgument() {
        String input1 = "//;\n1;2;3";
        String input2 = "//!\n1!2,5";
        String input3 = "//a\n1a2,3:4";

        int expected1 = 6;
        int expected2 = 8;
        int expected3 = 10;

        return Stream.of(
                Arguments.arguments(input1, expected1),
                Arguments.arguments(input2, expected2),
                Arguments.arguments(input3, expected3)
        );
    }
}

