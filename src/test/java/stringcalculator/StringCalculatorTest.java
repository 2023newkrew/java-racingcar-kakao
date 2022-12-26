package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator(new HashSet<>(List.of(",", ":")));
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
    @DisplayName("기본 구분자인 쉼표(,) 또는 콜론(:)을 기준으로 분리한다.")
    void splitStringByBaseDelimiters() {
        String input = "1:2,3";

        String[] result = stringCalculator.splitByDelimiter(input);

        assertThat(result.length).isEqualTo(3);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자를 등록한다.")
    void registerCustomDelimiter() {
        String input = "//;\n1;2;3";

        stringCalculator.registerDelimiterIfNotExist(input);
        Set<String> delimiters = stringCalculator.getDelimiters();

        assertThat(delimiters.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("커스텀 구분자를 기준으로 분리한다.")
    void splitStringByCustomDelimiter() {
        String input = "//_\n6_1:5";

        stringCalculator.registerDelimiterIfNotExist(input);
        String str = stringCalculator.parseNumberContainingString(input);
        String[] result = stringCalculator.splitByDelimiter(str);

        assertThat(result.length).isEqualTo(3);
        assertThat(result).containsExactly("6", "1", "5");
    }

    @Test
    @DisplayName("양의 정수들을 더한다.")
    void addNumber() {
        String input = "1:2:3";
        String[] strArr = stringCalculator.splitByDelimiter(input);
        IntegerList numberList = new IntegerList(strArr);

        int result = numberList.calculateSum();
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("입력된 문자열에 맞게 계산한다.")
    void playStringCalculator() {
        String input = "1:2:3";

        int result = stringCalculator.run(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("입력된 문자열에 맞게 계산한다.")
    void playStringCalculatorWithCustomDelimiter() {
        String input = "//;\n5:2;9";

        int result = stringCalculator.run(input);
        assertThat(result).isEqualTo(16);
    }

}
