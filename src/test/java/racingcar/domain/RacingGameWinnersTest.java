package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RacingGameWinnersTest {

    @Test
    void create() {
        RacingGameWinners racingGameWinners = new RacingGameWinners(
                Arrays.asList(
                        new RacingCar("car1"),
                        new RacingCar("car2")
                )
        );
        Assertions.assertThat(racingGameWinners).isEqualTo(new RacingGameWinners(
                Arrays.asList(
                        new RacingCar("car1"),
                        new RacingCar("car2")
                )
        ));
    }
}
