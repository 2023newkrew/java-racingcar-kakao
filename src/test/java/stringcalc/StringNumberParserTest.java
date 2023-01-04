package stringcalc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringNumberParserTest {

    @Test
    public void parseStringNumber_defaultSeparator() {
        // given
        Optional<String> separator = Optional.empty();
        String input = "1:2:3,4";

        // when
        StringNumberParser stringNumberParser = new StringNumberParser();
        List<Long> numbers = stringNumberParser.parseToNumberList(input, separator);

        // then
        assertThat(numbers).hasSize(4);
        assertThat(numbers).containsExactly(1L, 2L, 3L, 4L);
    }

    @Test
    public void parseStringNumber_singleNumber() {
        // given
        Optional<String> separator = Optional.empty();
        String input = "1";

        // when
        StringNumberParser stringNumberParser = new StringNumberParser();
        List<Long> numbers = stringNumberParser.parseToNumberList(input, separator);

        // then
        assertThat(numbers).hasSize(1);
        assertThat(numbers).containsExactly(1L);
    }

    @Test
    public void parseStringNumber_empty() {
        // given
        Optional<String> separator = Optional.empty();
        String input = "";

        // when
        StringNumberParser stringNumberParser = new StringNumberParser();
        List<Long> numbers = stringNumberParser.parseToNumberList(input, separator);

        // then
        assertThat(numbers).isEmpty();
    }

    @Test
    public void parseStringNumber_customSeparator() {
        // given
        Optional<String> separator = Optional.of(";");
        String input = "//;\n1;2;3;4";

        // when
        StringNumberParser stringNumberParser = new StringNumberParser();
        List<Long> numbers = stringNumberParser.parseToNumberList(input, separator);

        // then
        assertThat(numbers).hasSize(4);
        assertThat(numbers).containsExactly(1L, 2L, 3L, 4L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:-2:3,4", "1, ,3:4", "1,a:3,4", "1,2,3,4\n", "1,,,2"})
    public void parseStringNumber_throw(String input) {
        // given
        Optional<String> separator = Optional.empty();

        // when
        StringNumberParser stringNumberParser = new StringNumberParser();

        // then
        assertThatThrownBy(() -> stringNumberParser.parseToNumberList(input, separator)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;-2;3;4", "//;\n1; ;3;4", "//;\n1;a;3;4", "//;\n\n1;2;3;4"})
    public void parseStringNumber_throw_customSeparator(String input) {
        // given
        Optional<String> separator = Optional.of(";");

        // when
        StringNumberParser stringNumberParser = new StringNumberParser();

        // then
        assertThatThrownBy(() -> stringNumberParser.parseToNumberList(input, separator)).isInstanceOf(RuntimeException.class);
    }
}
