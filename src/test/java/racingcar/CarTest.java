package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void moveCar() {
        Car car = new Car();
        int prevPosition = car.getPosition();
        car.move();
        Assertions.assertThat(car.getPosition())
                .isEqualTo(prevPosition + 1);
    }
}
