package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ParserTest {
    @Test
    void parse() {
        assertThat(StringParser.parse("pobi,crong,honux")).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
    }
}
