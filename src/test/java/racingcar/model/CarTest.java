package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void carForwarding() {
        Car car = new Car("davi");
        car.forward();
        assertThat(car.getDistance()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
    }
}
