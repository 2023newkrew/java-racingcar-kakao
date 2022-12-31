package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingCarsTest {

    @Test
    void create() {
        String[] racingCarNames = new String[]{"car1", "car2", "car3"};

        RacingCars racingCars = new RacingCars(racingCarNames);

        assertThat(racingCars).isEqualTo(new RacingCars(new String[]{"car1", "car2", "car3"}));
    }

    @Test
    void create_throwEx() {
        assertThatThrownBy(() -> new RacingCars(new String[]{"longName"})).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차들의 이름과 distance를 -로 출력한다")
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
