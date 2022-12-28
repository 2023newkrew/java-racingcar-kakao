package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.StubNumberGenerator;

class RacingSimulatorTest {

    private static final int MOVE = 4;
    private static final int STOP = 3;

    @DisplayName("1대 이상의 자동차가 경주에 참가해야한다.")
    @Test
    void mustParticipateTwoCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);

        assertThatThrownBy(() -> new RacingSimulator(1, numberGenerator, Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수를 넘어서 자동차를 이동시킬 수 없다")
    @Test
    void overTryCountTest() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        RacingSimulator simulator = new RacingSimulator(2, numberGenerator, List.of("a"));

        simulator.move();
        simulator.move();

        assertThatThrownBy(() -> simulator.move())
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("특정 값 이상인 경우 자동차를 이동시킨다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveCar(int value) {
        NumberGenerator numberGenerator = new StubNumberGenerator(value);
        RacingSimulator simulator = new RacingSimulator(5, numberGenerator, List.of("a"));

        simulator.move();

        Positions positions = simulator.getPositions();
        assertThat(positions.getPositionByName("a")).isEqualTo(1);
    }

    @DisplayName("특정 값 이하인 경우 자동차를 정지시킨다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopCar(int value) {
        NumberGenerator numberGenerator = new StubNumberGenerator(value);
        RacingSimulator simulator = new RacingSimulator(5, numberGenerator, List.of("a"));

        simulator.move();

        Positions positions = simulator.getPositions();
        assertThat(positions.getPositionByName("a")).isEqualTo(0);
    }

    @DisplayName("여러 대의 자동차를 이동 혹은 정지시킨다.")
    @Test
    void moveOrStopCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        RacingSimulator simulator = new RacingSimulator(5, numberGenerator, List.of("a", "b", "c"));

        simulator.move();

        Positions positions = simulator.getPositions();
        assertThat(positions.getPositionByName("a")).isEqualTo(1);
        assertThat(positions.getPositionByName("b")).isEqualTo(1);
        assertThat(positions.getPositionByName("c")).isEqualTo(0);
    }

    @DisplayName("가장 멀리 이동한 차가 단독 우승한다")
    @Test
    void getSoloWinner() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, STOP, STOP,
                MOVE, MOVE, MOVE
        );
        RacingSimulator simulator = new RacingSimulator(3, numberGenerator, List.of("a", "b", "c"));

        simulator.move();
        simulator.move();
        simulator.move();
        Winners winners = simulator.getWinners();

        assertThat(winners.getWinnerCars())
                .extracting(Car::getName)
                .hasSize(1)
                .contains("a");
    }

    @DisplayName("가장 멀리 이동한 자동차가 공동 우승한다")
    @Test
    void getCoWinners() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, MOVE, MOVE,
                MOVE, MOVE, MOVE
        );
        RacingSimulator simulator = new RacingSimulator(3, numberGenerator, List.of("a", "b", "c"));

        simulator.move();
        simulator.move();
        simulator.move();

        Winners winners = simulator.getWinners();
        assertThat(winners.getWinnerCars())
                .hasSize(2)
                .extracting(Car::getName)
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
        RacingSimulator simulator = new RacingSimulator(3, numberGenerator, List.of("a", "b", "c"));

        simulator.move();

        assertThatThrownBy(() -> simulator.getWinners())
                .isInstanceOf(IllegalStateException.class);
    }
}
