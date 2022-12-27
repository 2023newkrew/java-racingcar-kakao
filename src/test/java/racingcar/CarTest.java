package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void shouldNotMove(int no) {
        Car car = new Car();

        car.move(no);
        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void shouldMove(int no) {
        Car car = new Car();

        car.move(no);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
