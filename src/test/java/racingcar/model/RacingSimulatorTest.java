package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import racingcar.StubNumberGenerator;

class RacingSimulatorTest {

    private static final int MOVE = 4;
    private static final int STOP = 3;

    @Test
    void overTryCountTest() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        Cars cars = createCars(numberGenerator, "a");
        RacingSimulator simulator = createRacingSimulator(2, cars);

        assertThatThrownBy(() -> move(simulator, 3))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void moveCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        Cars cars = createCars(numberGenerator, "a", "b", "c");
        RacingSimulator simulator = createRacingSimulator(5, cars);

        move(simulator, 1);

        Cars result = simulator.getCars();
        assertThat(result.getPositionByName("a")).isEqualTo(1);
        assertThat(result.getPositionByName("b")).isEqualTo(1);
        assertThat(result.getPositionByName("c")).isEqualTo(0);
    }

    @Test
    void getSoloWinner() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, STOP, STOP,
                MOVE, MOVE, MOVE
        );
        Cars cars = createCars(numberGenerator, "a", "b", "c");
        RacingSimulator simulator = createRacingSimulator(3, cars);

        move(simulator, 3);

        List<Car> winners = simulator.getCars().getWinners();
        assertThat(winners)
                .extracting(Car::getName)
                .hasSize(1)
                .contains("a");
    }

    @Test
    void getCoWinners() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, MOVE, MOVE,
                MOVE, MOVE, MOVE
        );
        Cars cars = createCars(numberGenerator, "a", "b", "c");
        RacingSimulator simulator = createRacingSimulator(3, cars);

        move(simulator, 3);

        List<Car> winners = simulator.getCars().getWinners();
        assertThat(winners)
                .hasSize(2)
                .extracting(Car::getName)
                .contains("a", "b");
    }

    private static Cars createCars(NumberGenerator numberGenerator, String... names) {
        List<Car> cars = Stream.of(names)
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(numberGenerator, cars);
    }

    private static RacingSimulator createRacingSimulator(int maxTryCount, Cars cars) {
        return new RacingSimulator(maxTryCount, cars);
    }

    private static void move(RacingSimulator simulator, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            simulator.move();
        }
    }
}
