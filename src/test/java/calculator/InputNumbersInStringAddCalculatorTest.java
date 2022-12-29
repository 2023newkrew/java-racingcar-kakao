package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumbersInStringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void NULL_이거나_빈문자열이면_계산결과는_0이다 (String input) {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator(input);
        assertThat(calculator.calculate()).isEqualTo(0);
    }

    @Test
    void 구분자_없이_숫자만_계산이_잘되는지_확인() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("1");
        assertThat(calculator.calculate()).isEqualTo(1);
    }
    @Test
    void 콤마로_구분된_숫자가_덧셈이_잘되는지_확인() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("1,2");
        assertThat(calculator.calculate()).isEqualTo(3);
    }

    @Test
    void 콜론으로_구분된_숫자가_덧셈이_잘되는지_확인() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("1:2");
        assertThat(calculator.calculate()).isEqualTo(3);
    }

    @Test
    void 콤마와_콜론으로_구분된_숫자가_덧셈이_잘되는지_확인() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("1,2:3");
        assertThat(calculator.calculate()).isEqualTo(6);
    }

    @Test
    void 커스텀구분자로_구분된_숫자가_덧셈이_잘되는지_확인() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("//;\n1;2");
        assertThat(calculator.calculate()).isEqualTo(3);
    }

    @Test
    void 콤마_콜론_커스텀구분자로_구분된_숫자의_덧셈이_잘되는지_확인() {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator("//A\n1,2:3A4");
        assertThat(calculator.calculate()).isEqualTo(10);
    }

    @ValueSource(strings = {"2.3", "ab9", "1e9"})
    @ParameterizedTest
    void 정수가_아닌_문자열이_주어졌을_경우_예외가_발생한다(String input) {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator(input);
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(RuntimeException.class);
    }

    @ValueSource(strings = {"-3", "-7:124", "//;\n1;2:-3"})
    @ParameterizedTest
    void 음수인_정수가_입력되면_예외가_발생한다(String input) {
        InputNumbersInStringAddCalculator calculator = new InputNumbersInStringAddCalculator(input);
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(RuntimeException.class);
    }
}
