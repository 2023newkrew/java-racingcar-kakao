package stringcalculator;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator(Set.of(",",":"));
    }

    @Test
    @DisplayName("빈 문자열을 입력할 경우 0을 반환한다.")
    void returnZeroIfEmptyString() {
        int result = stringCalculator.play("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("null 값을 입력할 경우 0을 반환한다.")
    void returnZeroIfNull() {
        int result = stringCalculator.play(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void returnOneIfNumberCharacter() {
        String input = "1";
        int expectedResult = Integer.parseInt(input);

        int result = stringCalculator.play(input);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("입력된 하나의 문자열이 숫자가 아닌 경우 예외가 발생한다.")
    void throwExceptionIfCharacterIsNotNumber() {
        String input = "-";

        assertThatThrownBy(() -> stringCalculator.play(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("기본 구분자인 쉼표(,) 또는 콜론(:)을 기준으로 분리한다.")
    void splitStringByComma() {
        String input = "1:2,3";

        String[] result = stringCalculator.splitByDelimiter(input);

        assertThat(result.length).isEqualTo(3);
        assertThat(result).containsExactly("1", "2", "3");
    }

}
