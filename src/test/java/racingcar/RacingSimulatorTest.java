package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class RacingSimulatorTest {

    private static final int MOVE = 4;
    private static final int STOP = 3;

    @Test
    void overTryCountTest() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        RacingSimulator simulator = createRacingSimulator(numberGenerator, 2, "a");

        assertThatThrownBy(() -> move(simulator, 3))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void moveCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        RacingSimulator simulator = createRacingSimulator(numberGenerator, 5, "a", "b", "c");

        move(simulator, 1);

        Result result = simulator.getResult();
        assertThat(result.getPositionByName("a")).isEqualTo(1);
        assertThat(result.getPositionByName("b")).isEqualTo(1);
        assertThat(result.getPositionByName("c")).isEqualTo(0);
    }

    @Test
    void getSoloWinner() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP, MOVE, STOP, STOP, MOVE, MOVE, MOVE);
        RacingSimulator simulator = createRacingSimulator(numberGenerator, 3, "a", "b", "c");

        move(simulator, 3);

        Car winner = simulator.getWinner();
        assertThat(winner.getName()).isEqualTo("a");
    }

    private static RacingSimulator createRacingSimulator(NumberGenerator numberGenerator, int maxTryCount, String... names) {
        List<Car> cars = Stream.of(names)
                .map(Car::new)
                .collect(Collectors.toList());

        return new RacingSimulator(maxTryCount, numberGenerator, cars);
    }

    private static void move(RacingSimulator simulator, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            simulator.move();
        }
    }
}
