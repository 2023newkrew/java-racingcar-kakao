package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void init() {
        StringParser stringParser = new StringParser();
        calculator = new Calculator(stringParser);
    }

    @DisplayName("계산기 더하기 연산 검증")
    @Test
    void addTest() {
        //given
        StringParser stringParser = new StringParser();
        Calculator calculator = new Calculator(stringParser);

        Integer[] inputs0 = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] inputs1 = new Integer[]{};
        //when
        //then
        Assertions.assertThat(calculator.addInteger(inputs0)).isEqualTo(55);
        Assertions.assertThat(calculator.addInteger(inputs1)).isEqualTo(0);
    }

    @DisplayName("테스트 스트링 합쳐서 6 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "//;\\n1;2,3", "1:2:3"})
    void calculateTest_stringAddition(String string) {
        //given
        //when
        Integer result = calculator.addString(string);
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
        Assertions.assertThatRuntimeException().isThrownBy(() -> calculator.addString(string));
    }

    @DisplayName("빈문자열 & null은 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void calculateTest_nullAndEmptyIsZero(String string) {
        //given
        //when
        Integer result = calculator.addString(string);
        //then
        Assertions.assertThat(result).isEqualTo(0);
    }
}
