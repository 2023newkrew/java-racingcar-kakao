package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarsTest {

    @Test
    void create() {
        String[] racingCarNames = new String[]{"car1", "car2", "car3"};

        RacingCars racingCars = new RacingCars(racingCarNames);

        assertThat(racingCars).isEqualTo(new RacingCars(new String[]{"car1", "car2", "car3"}));
    }

    @ParameterizedTest
    @ValueSource(strings = {"longName", "", "  "})
    void create_throwEx(String input) {
        assertThatThrownBy(() -> new RacingCars(new String[]{input})).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차들의 이름과 distance를 문자열로 표현한다")
    @Test
    void printScore() {
        //given
        String[] racingCarNames = new String[]{"car1", "car2", "car3"};
        String expected = "car1 : -\n" +
                "car2 : -\n" +
                "car3 : -";

        //when
        RacingCars racingCars = new RacingCars(racingCarNames);

        //then
        assertThat(racingCars.toString()).hasToString(expected);
    }
}
