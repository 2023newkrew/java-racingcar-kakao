package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.dto.CarInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private final int INITIAL_DISTANCE = 1;
    @Test
    @DisplayName("Car의 기본 위치는 1이다")
    void constructorTest() {
        Car car = new Car("bryan");
        assertThat(car.getName()).isEqualTo("bryan");
        assertThat(car.getPosition()).isEqualTo(INITIAL_DISTANCE);
    }

    @Test
    @DisplayName("0에서 9 사이 임의의 숫자를 뽑는다")
    void pickRandomNumber() {
        Car car = new Car("car1");
        assertThat(car.pickRandomNumber()).isBetween(0, 9);
    }

    @Test
    @DisplayName("차가 이동하는 경우 위치값은 0 또는 1만큼 증가한다")
    void move() {
        Car car = new Car("car1");
        int beforeDistance = car.getPosition();
        car.move();
        int afterDistance = car.getPosition();
        assertThat(afterDistance).isBetween(beforeDistance, beforeDistance + 1);
    }

    @Test
    void toStringTest() {
        Car car = new Car("sienna");
        assertThat(car.toString()).isEqualTo("차 이름: sienna, 거리: " + INITIAL_DISTANCE);
    }

    @Test
    @DisplayName("Car를 CarInfo로 변환하는 경우 이름과 위치값은 변하지 않는다")
    void transformDtoTest() {
        Car car1 = new Car("sienna");
        Car car2 = new Car("bryan");
        List<Car> cars = List.of(car1, car2);
        List<CarInfo> carInfos = CarInfo.of(cars);
        assertThat(carInfos.get(0).getName()).isEqualTo("sienna");
        assertThat(carInfos.get(1).getName()).isEqualTo("bryan");
        assertThat(carInfos.get(0).getPosition()).isEqualTo(INITIAL_DISTANCE);
        assertThat(carInfos.get(1).getPosition()).isEqualTo(INITIAL_DISTANCE);
    }
}
