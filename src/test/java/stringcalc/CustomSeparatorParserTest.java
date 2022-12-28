package stringcalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomSeparatorParserTest {

    CustomSeparatorParser customSeparatorParser;

    @BeforeEach
    void setUp() {
        customSeparatorParser = new CustomSeparatorParser();
    }

    @Test
    void parseCustomSeparator(){
        //given
        String input = "//;\n1;2;3";

        //when
        String result = customSeparatorParser.parse(input);

        //then
        assertThat(result).isEqualTo(";");
    }

    @Test
    void parseCustomSeparator_throwEx(){
        //given
        String input = "//;;\n1;2;3";

        //then
        assertThatThrownBy(() -> customSeparatorParser.parse(input)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void parseCustomSeparator_noCustomSeparator() {
        //given
        String input = "1,2,3";

        //when
        String result = customSeparatorParser.parse(input);

        //then
        assertThat(result).isNull();
    }

    @Test
    void parseCustomSeparator_Empty() {
        //given
        String input = "";

        //when
        String result = customSeparatorParser.parse(input);

        //then
        assertThat(result).isNull();
    }
}
