package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void constructorTest() {
        Car car = new Car("bryan");
        assertThat(car.getName()).isEqualTo("bryan");
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void pickNumber() {
        Car car = new Car("car1");
        assertThat(car.pickNumber()).isBetween(0, 9);
    }

    @Test
    void move() {
        Car car = new Car("car1");
        int beforeDistance = car.getDistance();
        car.move();
        int afterDistance = car.getDistance();
        assertThat(afterDistance).isBetween(beforeDistance, beforeDistance + 1);
    }

    @Test
    void toStringTest() {
        Car car = new Car("sienna");
        assertThat(car.toString()).isEqualTo("차 이름: sienna, 거리: 0");
    }
}
