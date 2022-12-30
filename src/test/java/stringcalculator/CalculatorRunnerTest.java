package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorRunnerTest {
    CalculatorRunner calculatorRunner;

    @BeforeEach
    void init() {
        StringParser stringParser = new StringParser();
        calculatorRunner = new CalculatorRunner(stringParser);
    }

    @DisplayName("테스트 스트링 합쳐서 6 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "//;\\n1;2,3", "1:2:3"})
    void calculateTest_stringAddition(String string) {
        //given
        //when
        Integer result = calculatorRunner.calculate(string);
        //then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("처리 불가능한 입력 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"asd,2,4", "1+2,3"})
    void calculateTest_invalidInput(String string) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> calculatorRunner.calculate(string));
    }

    @DisplayName("빈문자열 & null은 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void calculateTest_nullAndEmptyIsZero(String string) {
        //given
        //when
        Integer result = calculatorRunner.calculate(string);
        //then
        Assertions.assertThat(result).isEqualTo(0);
    }
}