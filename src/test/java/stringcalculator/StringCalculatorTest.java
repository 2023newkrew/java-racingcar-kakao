package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator(List.of(",", ":"));
    }

    @Test
    @DisplayName("빈 문자열을 입력할 경우 0을 반환한다.")
    void returnZeroIfEmptyString() {
        int result = stringCalculator.run("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("null 값을 입력할 경우 0을 반환한다.")
    void returnZeroIfNull() {
        int result = stringCalculator.run(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void returnOneIfNumberCharacter() {
        String input = "1";
        int expectedResult = Integer.parseInt(input);

        int result = stringCalculator.run(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("입력된 하나의 문자열이 숫자가 아닌 경우 예외가 발생한다.")
    void throwExceptionIfCharacterIsNotNumber() {
        String input = "-";

        assertThatThrownBy(() -> stringCalculator.run(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력된 문자열에 맞게 계산한다.")
    void playStringCalculator() {
        String input = "1:2:3";

        int result = stringCalculator.run(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 문자열에 맞게 계산한다.")
    void playStringCalculatorWithCustomDelimiter() {
        String input = "//;\n5:2;9";

        int result = stringCalculator.run(input);
        assertThat(result).isEqualTo(16);
    }

    @Test
    @DisplayName("양의 정수가 들어가야 할 자리에 특수 문자를 입력할 경우 예외가 발생한다.")
    void playStringCalculatorWithInvalidInput1() {
        String input = "//;\n_:2;9";

        assertThatThrownBy(() -> stringCalculator.run(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("양의 정수가 들어가야 할 자리에 음수를 입력할 경우 예외가 발생한다.")
    void playStringCalculatorWithInvalidInput2() {
        String input = "//;\n-1:2;9";

        assertThatThrownBy(() -> stringCalculator.run(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수만 입력될 경우 예외가 발생한다.")
    void playStringCalculatorWithInvalidInput3() {
        String input = "-1";

        assertThatThrownBy(() -> stringCalculator.run(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("패턴은 일치하지만, 구분자가 숫자인 경우 예외가 발생한다.")
    void playStringCalculatorWithInvalidInput4() {
        String input = "//6\n26269";

        assertThatThrownBy(() -> stringCalculator.run(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("사용자의 입력값이 커스텀 구분자 패턴과 일치하지 않는 경우 예외가 발생한다.")
    void playStringCalculatorWithInvalidInput5() {
        String input = "//;_\n2;2_9";

        assertThatThrownBy(() -> stringCalculator.run(input))
                .isInstanceOf(RuntimeException.class);
    }

}
