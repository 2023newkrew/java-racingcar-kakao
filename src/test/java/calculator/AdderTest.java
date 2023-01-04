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
    @DisplayName("기본 구분자가 주어졌을 때 올바른 계산결과를 반환한다.")
    void addNormalTest() {
        String input = "1:2:3";
        NumberParser numberParser = new NumberParser(input, defaultDelimiters);
        numberParser.parseNumbersStr();
        int[] intArr = numberParser.convertParsedNumbersToIntArr();
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("사용자정의 구분자가 주어졌을 때 올바른 계산결과를 반환한다.")
    void addCustomTest() {
        String input = "//;\n4;6;9";
        NumberParser numberParser = new NumberParser(input, defaultDelimiters);
        numberParser.parseNumbersStr();
        int[] intArr = numberParser.convertParsedNumbersToIntArr();
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(19);
    }

    @Test
    @DisplayName("숫자가 아닌 입력에서 오류를 표출한다.")
    void addWrongTest() {
        String input = "//;\n4;w;9";
        NumberParser numberParser = new NumberParser(input, defaultDelimiters);
        numberParser.parseNumbersStr();
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(numberParser::convertParsedNumbersToIntArr);
    }

    @Test
    @DisplayName("음수 입력에서 오류를 표출한다.")
    void addNegativeTest() {
        String input = "//;\n4;-10;9";
        NumberParser numberParser = new NumberParser(input, defaultDelimiters);
        numberParser.parseNumbersStr();
        Assertions.assertThatExceptionOfType(NegativeValueException.class)
                .isThrownBy(numberParser::convertParsedNumbersToIntArr);
    }

    @ParameterizedTest
    @DisplayName("공백, Null 입력에 대해 0 결과 반환한다.")
    @NullSource
    @ValueSource(strings = {""})
    void emptyTest(String input) {
        NumberParser numberParser = new NumberParser(input, defaultDelimiters);
        numberParser.parseNumbersStr();
        int[] intArr = numberParser.convertParsedNumbersToIntArr();
        int result = Adder.run(intArr);
        Assertions.assertThat(result).isEqualTo(0);
    }
}
