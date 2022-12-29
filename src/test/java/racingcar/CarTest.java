package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void checkCarNameLengthLimit() {
        assertThrows(RuntimeException.class, () -> new Car("long_name"));
    }

    @Test
    void move() {
        Car car = new Car("자동차");
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
