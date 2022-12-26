package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingSimulatorTest {

    @Test
    void overTryCountTest() {
        NumberGenerator numberGenerator = new StubNumberGenerator(4, 5, 3);
        List<Car> cars = List.of(new Car("c"));
        RacingSimulator simulator = new RacingSimulator(2, numberGenerator, cars);

        simulator.move();
        simulator.move();

        assertThatThrownBy(() -> simulator.move())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void moveCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(4, 5, 3);
        List<Car> cars = List.of(new Car("a"), new Car("b"), new Car("c"));
        RacingSimulator simulator = new RacingSimulator(5, numberGenerator, cars);

        simulator.move();

        Result result = simulator.getResult();
        assertThat(result.getPositionByName("a")).isEqualTo(1);
        assertThat(result.getPositionByName("b")).isEqualTo(1);
        assertThat(result.getPositionByName("c")).isEqualTo(0);
    }
}
