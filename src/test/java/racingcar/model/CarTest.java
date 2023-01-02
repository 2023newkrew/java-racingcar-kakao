package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @DisplayName("Car move test")
    @Test
    void moveTest() {
        Car car = new Car("test");

        car.move();

        assertEquals(car.getPosition(), 2);
    }
}
