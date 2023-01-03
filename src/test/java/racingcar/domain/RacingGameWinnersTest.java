package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameWinnersTest {

    @DisplayName("RacingCar 리스트를 인자로 받아 RacingGameWinners 객체를 생성한다")
    @Test
    void create() {
        RacingGameWinners racingGameWinners = new RacingGameWinners(
                Arrays.asList(
                        new RacingCar("car1"),
                        new RacingCar("car2")
                )
        );
        assertThat(racingGameWinners).isEqualTo(new RacingGameWinners(
                Arrays.asList(
                        new RacingCar("car1"),
                        new RacingCar("car2")
                )
        ));
    }

    @DisplayName("공동 우승자를 찾아서 반환한다")
    @Test
    void findWinners() {
        RacingGameWinners racingGameWinners = new RacingGameWinners(
                Arrays.asList(
                        new RacingCar("car1", 3),
                        new RacingCar("car2", 5),
                        new RacingCar("car3", 5)
                )
        );

        RacingGameWinners expected = new RacingGameWinners(Arrays.asList(
                new RacingCar("car2", 5),
                new RacingCar("car3", 5)
        ));

        assertThat(racingGameWinners).isEqualTo(expected);
    }

    @DisplayName("자동차가 한 대 인 경우 해당 자동차가 우승자이다")
    @Test
    void findWinners_singleWinner() {
        RacingGameWinners racingGameWinners = new RacingGameWinners(
                List.of(new RacingCar("car1", 3))
        );

        RacingGameWinners expected = new RacingGameWinners(
                List.of(new RacingCar("car1", 3))
        );

        assertThat(racingGameWinners).isEqualTo(expected);
    }

    @DisplayName("자동차 목록이 null이거나 비어있는 경우 예외 발생한다")
    @Test
    void throwEx() {
        assertThatThrownBy(() -> new RacingGameWinners(null))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RacingGameWinners(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
