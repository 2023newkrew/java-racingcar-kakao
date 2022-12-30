package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringParserTest {

    @DisplayName("추가 구분자 없는 문자열 분해")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
    void parseTest_validInputWithoutCustomSplitter(String input) {
        //given
        StringParser stringParser = new StringParser();
        //when
        Integer[] output = stringParser.parse(input);
        //then
        Assertions.assertThat(output).isEqualTo(new Integer[] {1, 2, 3});
    }

    @DisplayName("추가 구분자 있는 문자열 분해")
    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2:3", "//-\\n1,2-3", "//!\\n1!2!3"})
    void parseTest_validInputWithCustomSplitter(String input) {
        //given
        StringParser stringParser = new StringParser();
        //when
        Integer[] output = stringParser.parse(input);
        //then
        Assertions.assertThat(output).isEqualTo(new Integer[] {1, 2, 3});
    }

    @DisplayName("빈문자열 & null은 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void parseTest_isNullAndEmptyReturnZero(String input) {
        //given
        StringParser stringParser = new StringParser();
        //when
        Integer[] output = stringParser.parse(input);
        //then
        Assertions.assertThat(output).isEqualTo(new Integer[] {0});
    }

    @DisplayName("허용안된 문자 있는 입력 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"//a\\n1;2:3", "\\//;\n1,2;3", "a!2!3", "hello", "1;2:3", "-1,2,3"})
    void parseTest_invalidInput(String input) {
        //given
        StringParser stringParser = new StringParser();
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> stringParser.parse(input));
    }
}
