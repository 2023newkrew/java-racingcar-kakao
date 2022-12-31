package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarsTest {

    RacingCars racingCars;
    String[] racingCarNames;

    @BeforeEach
    void setUp() {
        racingCarNames = new String[]{"car1", "car2", "car3"};
        racingCars = new RacingCars(racingCarNames);
    }

    @DisplayName("자동차 이름 배열을 인자로 받아 RacingCars를 생성한다")
    @Test
    void create() {
        assertThat(racingCars).isEqualTo(new RacingCars(racingCarNames));
    }

    @DisplayName("자동차 이름이 빈 문자열이거나 공백일 경우, 5글자 초과할 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"longName", "", "  "})
    void create_throwEx(String input) {
        assertThatThrownBy(() -> new RacingCars(new String[]{input})).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차들의 이름과 distance를 문자열로 표현한다")
    @Test
    void printScore() {
        //given
        String expected = "car1 : -\n" +
                "car2 : -\n" +
                "car3 : -";

        //then
        assertThat(racingCars.toString()).hasToString(expected);
    }
}
