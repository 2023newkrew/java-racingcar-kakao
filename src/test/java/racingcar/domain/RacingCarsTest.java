package racingcar.domain;

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
}
