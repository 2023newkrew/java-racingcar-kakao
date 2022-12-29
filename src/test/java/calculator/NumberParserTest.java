package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;

public class NumberParserTest {

    private static final List<String> defaultDelimiters = Arrays.asList(",", ":");

    @Test
    @DisplayName("기본 구분자로 문자열 분할")
    void inputToStringArray() {
        NumberParser numberParser = new NumberParser("1:2:3", defaultDelimiters);
        Assertions.assertThat(numberParser.parseNumbersStr()).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("사용자 정의 구분자로 문자열 분할")
    void customInputToStringArray() {
        NumberParser numberParser = new NumberParser("//s\n1s2s3", defaultDelimiters);
        Assertions.assertThat(numberParser.parseNumbersStr()).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("String 배열 -> Integer 배열")
    void stringArrayToIntArray() {
        NumberParser numberParser = new NumberParser("1:2:3", defaultDelimiters);
        numberParser.parseNumbersStr();
        Assertions.assertThat(numberParser.convertParsedNumbersToIntArr()).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("String 배열에 숫자로 변환할 수 없는 원소가 존재시 예외처리")
    void stringArrayToIntArrayException() {
        NumberParser numberParser = new NumberParser("a:2:3", defaultDelimiters);
        numberParser.parseNumbersStr();

        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(numberParser::convertParsedNumbersToIntArr);
    }

    @Test
    @DisplayName("String 배열을 Integer 배열로 변환했을 때 음수가 있는 경우 예외처리")
    void negativeValueException() {
        NumberParser numberParser = new NumberParser("-1:2:3", defaultDelimiters);
        numberParser.parseNumbersStr();

        assertThatExceptionOfType(NegativeValueException.class)
                .isThrownBy(numberParser::convertParsedNumbersToIntArr);
    }
}
