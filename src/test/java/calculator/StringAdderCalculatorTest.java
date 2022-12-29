package calculator;

import calculator.domain.Calculator;
import calculator.domain.Prompt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAdderCalculatorTest {

    private Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @NullAndEmptySource
    public void empty(String input) {
        assertThat(calculator.calculate(new Prompt(input))).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ValueSource(strings = {"1", "24"})
    public void singleInteger(String input) {
        assertThat(calculator.calculate(new Prompt(input))).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    public void addIntegerSeparatedByComma() {
        assertThat(calculator.calculate(new Prompt("1,4"))).isEqualTo(5 );
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    public void addIntegerSeparatedByCustomDelimiter() {
        assertThat(calculator.calculate(new Prompt("//;\n1;2;3"))).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    public void isExistNegativeNumber() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                calculator.calculate(new Prompt("-1:2:3"));
            });
    }
}

