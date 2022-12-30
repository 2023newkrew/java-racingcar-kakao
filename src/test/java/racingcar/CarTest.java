package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopTest(int condition) {
        Car car = new Car("test", 0);

        car.moveCar(condition);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveTest(int condition) {
        Car car = new Car("test", 0);

        car.moveCar(condition);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
