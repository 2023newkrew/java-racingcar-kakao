package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @Test
    void findWinners() {
        String expected = "car2, car3가 최종 우승했습니다.";
        RacingGameWinners racingGameWinners = new RacingGameWinners(
                Arrays.asList(
                        new RacingCar("car1", 3),
                        new RacingCar("car2", 5),
                        new RacingCar("car3", 5)
                )
        );
        Assertions.assertThat(racingGameWinners.toString()).hasToString(expected);
    }

    @Test
    void findWinners_singleWinner() {
        String expected = "car1가 최종 우승했습니다.";
        RacingGameWinners racingGameWinners = new RacingGameWinners(
                List.of(new RacingCar("car1", 3))
        );
        Assertions.assertThat(racingGameWinners.toString()).hasToString(expected);
    }

    @Test
    void throwEx() {
        Assertions.assertThatThrownBy(() -> new RacingGameWinners(null))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new RacingGameWinners(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
