package racingcar.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차가_앞으로_전진한다() {
        Car car = new Car("davi", () -> true);
        car.forward();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 자동차가_정지한다() {
        Car car = new Car("sean", () -> false);
        car.forward();
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
