package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void parse() {
        assertThat(StringParser.parse("pobi,crong,honux")).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
    }
}
