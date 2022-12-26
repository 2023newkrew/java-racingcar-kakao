package racingCar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void move() {
        Car car = new Car("자동차");
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
