package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarNameTest {

    @Test
    void create_success() {
        RacingCarName racingCarName = new RacingCarName("name");
        assertThat(racingCarName).isEqualTo(new RacingCarName("name"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "longName"})
    void create_throwEx(String name) {
        assertThatThrownBy(() -> new RacingCarName(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
