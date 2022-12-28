package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class AdderTest {

    private static final List<String> defaultDelimiters = Arrays.asList(",", ":");
    @Test
    @DisplayName("기본 구분자")
    void addNormalTest() {
        String input = "1:2:3";
        NumberParser numberParser = new NumberParser(input, defaultDelimiters);
        numberParser.inputToStringArray();
        int[] intArr = numberParser.stringArrayToIntArray();
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("사용자정의 구분자")
    void addCustomTest() {
        String input = "//;\n4;6;9";
        NumberParser numberParser = new NumberParser(input, defaultDelimiters);
        numberParser.inputToStringArray();
        int[] intArr = numberParser.stringArrayToIntArray();
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(19);
    }

    @Test
    @DisplayName("숫자가 아닌 입력에서의 오류 표출")
    void addWrongTest() {
        String input = "//;\n4;w;9";
        NumberParser numberParser = new NumberParser(input, defaultDelimiters);
        numberParser.inputToStringArray();
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(numberParser::stringArrayToIntArray);
    }

    @Test
    @DisplayName("음수 입력에서의 오류 표출")
    void addNegativeTest() {
        String input = "//;\n4;-10;9";
        NumberParser numberParser = new NumberParser(input, defaultDelimiters);
        numberParser.inputToStringArray();
        Assertions.assertThatExceptionOfType(NegativeValueException.class)
                .isThrownBy(numberParser::stringArrayToIntArray);
    }

    @ParameterizedTest
    @DisplayName("공백, Null 입력에 대한 0 결과 반환")
    @NullSource
    @ValueSource(strings = {""})
    void emptyTest(String input) {
        NumberParser numberParser = new NumberParser(input, defaultDelimiters);
        numberParser.inputToStringArray();
        int[] intArr = numberParser.stringArrayToIntArray();
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(0);
    }
}
