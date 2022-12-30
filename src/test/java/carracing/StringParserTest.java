package carracing;

import carracing.domain.StringParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


class StringParserTest {
    @Test
    void parseTest_validInput() {
        //given
        String string = "a,b,c";
        //when
        String[] parsedStrings = StringParser.parse(string);
        //then
        Assertions.assertThat(parsedStrings).isEqualTo(new String[] {"a", "b", "c"});
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa,b,c", "a,,c"})
    void parseTest_invalidInput(String string) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> StringParser.parse(string));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void parseTest_nullAndEmpty(String string) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> StringParser.parse(string));
    }
}