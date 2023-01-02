package carracing;

import carracing.domain.StringParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}