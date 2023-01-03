package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarNameTest {

    @DisplayName("자동차 이름을 인자로 받아서 RacingCarName 객체를 생성한다")
    @Test
    void create_success() {
        RacingCarName racingCarName = new RacingCarName("name");
        assertThat(racingCarName).isEqualTo(new RacingCarName("name"));
    }

    @DisplayName("이름이 빈 문자열이거나, 공백이거나, 5글자를 초과할 경우 예외 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "longName"})
    void create_throwEx(String name) {
        assertThatThrownBy(() -> new RacingCarName(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
