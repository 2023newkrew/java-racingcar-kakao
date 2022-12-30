package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringParserTest {

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
