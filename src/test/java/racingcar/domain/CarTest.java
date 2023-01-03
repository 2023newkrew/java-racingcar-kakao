package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("차가 이동에 성공하는 경우 위치값은 1 증가한다")
    void move_success() {
        Car car = new Car("car1");
        int beforeDistance = car.getPosition();
        car.move(() -> true);
        int afterDistance = car.getPosition();
        assertThat(afterDistance).isEqualTo(beforeDistance + 1);
    }

    @Test
    @DisplayName("차가 이동에 실패하는 경우 위치값은 변하지 않는다")
    void move_fail() {
        Car car = new Car("car1");
        int beforeDistance = car.getPosition();
        car.move(() -> false);
        int afterDistance = car.getPosition();
        assertThat(afterDistance).isEqualTo(beforeDistance);
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
