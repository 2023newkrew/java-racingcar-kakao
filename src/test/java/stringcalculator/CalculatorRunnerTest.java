package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "//;\\n1;2,3", "1:2:3"})
    void calculateTest_stringAddition(String string) {
        //given
        //when
        Integer result = calculatorRunner.calculate(string);
        //then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd,2,4", "1+2,3"})
    void calculateTest_invalidInput(String string) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> calculatorRunner.calculate(string));
    }

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