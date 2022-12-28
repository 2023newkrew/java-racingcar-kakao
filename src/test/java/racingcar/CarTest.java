package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("can move if power is over the threshold")
    public void can_move_if_power_is_over_the_threshold() {
        Car car = new Car("name");
        car.accelerate(Car.POWER_THRESHOLD-1);
        assertEquals(0, car.getPosition());
        car.accelerate(Car.POWER_THRESHOLD);
        assertEquals(1, car.getPosition());
    }
}
