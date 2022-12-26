package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingSimulatorTest {

    @Test
    void moveCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(4, 5, 3);
        List<Car> cars = List.of(new Car("a"), new Car("b"), new Car("c"));
        RacingSimulator simulator = new RacingSimulator(numberGenerator, cars);

        simulator.move();

        Result result = simulator.getResult();
        assertThat(result.getPositionByName("a")).isEqualTo(1);
        assertThat(result.getPositionByName("b")).isEqualTo(1);
        assertThat(result.getPositionByName("c")).isEqualTo(0);
    }
}
