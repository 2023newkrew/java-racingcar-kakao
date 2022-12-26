package stringcalc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringNumberParserTest {

    @Test
    public void parseStringNumber_defaultSeparator() {
        // given
        String separator = null;
        String input = "1:2:3,4";

        // when
        StringNumberParser stringNumberParser = new StringNumberParser();
        List<Long> numbers = stringNumberParser.parse(input, separator);

        // then
        assertThat(numbers).hasSize(4);
        assertThat(numbers).containsExactly(1L, 2L, 3L, 4L);
    }

    @Test
    public void parseStringNumber_customSeparator() {
        // given
        String separator = ";";
        String input = "//;\n1;2;3;4";

        // when
        StringNumberParser stringNumberParser = new StringNumberParser();
        List<Long> numbers = stringNumberParser.parse(input, separator);

        // then
        assertThat(numbers).hasSize(4);
        assertThat(numbers).containsExactly(1L, 2L, 3L, 4L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;-2;3;4", "//;\n1; ;3;4", "//;\n1;a;3;4", "//;\n\n1;2;3;4"})
    public void parseStringNumber_throw(String input) {
        // given
        String separator = ";";

        // when
        StringNumberParser stringNumberParser = new StringNumberParser();

        // then
        assertThatThrownBy(() -> stringNumberParser.parse(input, separator)).isInstanceOf(RuntimeException.class);
    }
}
