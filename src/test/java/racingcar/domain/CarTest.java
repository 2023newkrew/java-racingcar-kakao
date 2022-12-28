package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 자동차가_앞으로_전진한다(int distance) {
        Car car = new Car("davi", () -> true, distance);
        car.forward();
        assertThat(car.getDistance()).isEqualTo(distance+1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 자동차가_정지한다(int distance) {
        Car car = new Car("sean", () -> false, distance);
        car.forward();
        assertThat(car.getDistance()).isEqualTo(distance);
    }
}
