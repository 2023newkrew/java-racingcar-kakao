package stringcalc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomSeparatorParserTest {

    CustomSeparatorParser customSeparatorParser;

    @BeforeEach
    void setUp() {
        customSeparatorParser = new CustomSeparatorParser();
    }

    @Test
    void parseCustomSeparator_1(){
        //given
        String input = "//;\n1;2;3";

        //when
        List<String> result = customSeparatorParser.parse(input);

        //then
        assertThat(result).hasSize(1);
        assertThat(result).containsExactly(";");
    }

    @Test
    void parseCustomSeparator_2(){
        //given
        String input = "//;\n//:\n1;2;3";

        //when
        List<String> result = customSeparatorParser.parse(input);

        //then
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(";", ":");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n//aa\n1;2;3", "//;\n/caa\n1;2;3", "//;\n\n1;2;3", "//;\n123//:\n1;2;3"})
    void parseCustomSeparator_throwEx(String input){
        //then
        assertThatThrownBy(() -> customSeparatorParser.parse(input)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void parseCustomSeparator_Empty() {
        //given
        String input = "";

        //when
        List<String> result = customSeparatorParser.parse(input);

        //then
        assertThat(result).isEmpty();
    }
}
