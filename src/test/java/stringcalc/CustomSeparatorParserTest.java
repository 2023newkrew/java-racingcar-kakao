package stringcalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomSeparatorParserTest {

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
        String result = customSeparatorParser.parseToCustomSeparator(input);

        //then
        assertThat(result).isEqualTo(";");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;;\n1;2;3"})
    void parseCustomSeparator_throwEx(String input){
        //then
        assertThatThrownBy(() -> customSeparatorParser.parseToCustomSeparator(input)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void parseCustomSeparator_Empty() {
        //given
        String input = "";

        //when
        String result = customSeparatorParser.parseToCustomSeparator(input);

        //then
        assertThat(result).isNull();
    }
}
