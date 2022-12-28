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
    void 빈_문자열이_입력되면_0을_반환(String input){
        //given
        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(0);


    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "12"})
    void 숫자가_하나만_입력되면_그대로_반환(String input){
        //given
        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "!ss", "12a"})
    void 숫자가_아닌_문자열이_입력되면_예외반환(String input) {
        //given
        //when & then
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @MethodSource("generator")
    void 정상문자열_입력되면_숫자합_반환(String input, Integer expected){
        //given
        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> generator(){
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("2;3,4", 9)
        );
    }

}
