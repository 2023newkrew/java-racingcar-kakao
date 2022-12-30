package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.StubNumberGenerator;

class RacingGameTest {

    private static final int MOVE = 4;
    private static final int STOP = 3;

    @DisplayName("1대 이상의 자동차가 경주에 참가해야한다.")
    @Test
    void mustParticipateTwoCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);

        assertThatThrownBy(() -> new RacingGame(1, numberGenerator, Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수를 넘어서 자동차를 이동시킬 수 없다")
    @Test
    void overTryCountTest() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        RacingGame racingGame = new RacingGame(2, numberGenerator, List.of("a"));

        racingGame.move();
        racingGame.move();

        assertThatThrownBy(() -> racingGame.move())
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("가장 멀리 이동한 자동차가 우승한다")
    @Test
    void getWinners() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                STOP, STOP, STOP,
                MOVE, MOVE, MOVE
        );
        RacingGame racingGame = new RacingGame(3, numberGenerator, List.of("a", "b", "c"));

        racingGame.move();
        racingGame.move();
        racingGame.move();
        Winners winners = racingGame.getWinners();

        assertThat(winners.getWinnerCars())
                .extracting(Car::getName)
                .hasSize(2)
                .contains("a", "b");
    }

    @DisplayName("경주가 끝나기 전에 우승자를 찾을 수 없다.")
    @Test
    void getNotDefinedWinners() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, MOVE, MOVE,
                MOVE, MOVE, MOVE
        );
        RacingGame racingGame = new RacingGame(3, numberGenerator, List.of("a", "b", "c"));

        racingGame.move();

        assertThatThrownBy(() -> racingGame.getWinners())
                .isInstanceOf(IllegalStateException.class);
    }
}
