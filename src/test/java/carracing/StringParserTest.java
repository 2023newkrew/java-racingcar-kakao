package carracing;

import carracing.domain.StringParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


class StringParserTest {
    StringParser stringParser;

    @BeforeEach
    void init() {
        stringParser = new StringParser();
    }

    @DisplayName("문자열 ',' 기준으로 split 성공")
    @Test
    void parseTest_validInput() {
        //given
        String string = "a,b,c";
        //when
        String[] parsedStrings = stringParser.parse(string);
        //then
        Assertions.assertThat(parsedStrings).isEqualTo(new String[] {"a", "b", "c"});
    }

    @DisplayName("처리 불가능한 이름 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa,b,c", "a,,c"})
    void parseTest_invalidInput(String string) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> stringParser.parse(string));
    }

    @DisplayName("빈문자열 & null 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void parseTest_nullAndEmpty(String string) {
        //given
        //when
        //then
        Assertions.assertThatRuntimeException().isThrownBy(() -> stringParser.parse(string));
    }
}