package racingcar;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void stopTest() {
        Car car = new Car("test");

        car.determineToMove(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void moveTest() {
        Car car = new Car("test");

        car.determineToMove(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
