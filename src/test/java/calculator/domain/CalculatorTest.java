package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;
    private Interpreter interpreter;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        interpreter = new Interpreter();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 빈_문자열_또는_null_값을_입력할_경우_0을_반환해야_한다(String input) {
        Command command = new Command(input);
        assertThat(calculator.calculate(command)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "24"})
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환한다(String input) {
        Command command = new Command(input);
        assertThat(calculator.calculate(command)).isEqualTo(Integer.parseInt(input));
    }

    @Test
    void 숫자_두개를_컴마_구분자로_입력할_경우_두_숫자의_합을_반환한다() {
        Command command = new Command("1,4");
        assertThat(calculator.calculate(command)).isEqualTo(5 );
    }

    @Test
    void 커스텀_구분자를_지정할_수_있다() {
        Command command = interpreter.decode("//;\n1;2;3");
        assertThat(calculator.calculate(command)).isEqualTo(6);
    }

    @Test
    void 음수를_전달할_경우_예외가_발생해야_한다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(interpreter.decode("-1:2:3"));
                });
    }
}

