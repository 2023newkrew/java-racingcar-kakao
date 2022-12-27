package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private final int INITIAL_DISTANCE = 1;
    @Test
    void constructorTest() {
        Car car = new Car("bryan");
        assertThat(car.getName()).isEqualTo("bryan");
        assertThat(car.getDistance()).isEqualTo(INITIAL_DISTANCE);
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
        assertThat(car.toString()).isEqualTo("차 이름: sienna, 거리: " + INITIAL_DISTANCE);
    }

    @Test
    void transformDtoTest() {
        Car car1 = new Car("sienna");
        Car car2 = new Car("bryan");
        List<Car> cars = List.of(car1, car2);
        List<CarInfo> carInfos = CarInfo.of(cars);
        assertThat(carInfos.get(0).getName()).isEqualTo("sienna");
        assertThat(carInfos.get(1).getName()).isEqualTo("bryan");
        assertThat(carInfos.get(0).getDistance()).isEqualTo(INITIAL_DISTANCE);
        assertThat(carInfos.get(1).getDistance()).isEqualTo(INITIAL_DISTANCE);
    }
}
