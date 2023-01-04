package stringcalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

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
        Optional<String> separatorOptional = customSeparatorParser.parseToCustomSeparator(input);
        String result = separatorOptional.orElse("[,:]");

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
        Optional<String> separatorOptional = customSeparatorParser.parseToCustomSeparator(input);

        //then
        assertThat(separatorOptional).isEmpty();
    }
}
