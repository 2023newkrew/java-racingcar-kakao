package stringcalc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void parseCustomSeparator_throwEx(){
        //given
        String input = "//;\n//aa\n1;2;3";

        //then
        assertThatThrownBy(() -> customSeparatorParser.parse(input)).isInstanceOf(RuntimeException.class);
    }
}
