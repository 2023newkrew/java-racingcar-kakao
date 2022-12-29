package racingcar.racing;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarDTO;
import racingcar.domain.racing.RacingWinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingWinnerTest {
    @Test
    void getWinners() {
        List<CarDTO> cars = new ArrayList<>();

        cars.add(new CarDTO("aa", 1));
        cars.add(new CarDTO("bb", 2));
        cars.add(new CarDTO("cc", 3));
        cars.add(new CarDTO("dd", 4));
        cars.add(new CarDTO("ee", 4));

        RacingWinner racingWinner = new RacingWinner(cars);
        RacingWinner expectedWinner = new RacingWinner(Arrays.asList(new CarDTO("dd", 4), new CarDTO("ee", 4)));

        assertThat(racingWinner).isEqualTo(expectedWinner);
    }
}
