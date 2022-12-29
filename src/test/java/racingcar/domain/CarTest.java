package racingcar.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private final int INITIAL_DISTANCE = 1;

    @Test
    void 자동자_생성시_주어진_이름과_초기_거리를_가진다() {
        Car car = new Car("bryan");

        assertThat(car.getName()).isEqualTo("bryan");
        assertThat(car.getDistance()).isEqualTo(INITIAL_DISTANCE);
    }

    @Test
    void 자동차는_0과_9_사이의_정수를_고를_수_있다() {
        Car car = new Car("new_car");

        assertThat(car.pickNumber()).isBetween(0, 9);
    }

    @RepeatedTest(100)
    void 자동차는_움직일_때_전진하거나_정지힐_수_있다() {
        Car car = new Car("new_car");

        int beforeDistance = car.getDistance();
        car.move();
        int afterDistance = car.getDistance();

        assertThat(afterDistance).isBetween(beforeDistance, beforeDistance + 1);
    }

    @Test
    void 자동차는_toString_을_통해_이름과_거리를_가진_문자열로_변환될_수_있다() {
        Car car = new Car("sienna");

        assertThat(car.toString())
                .isEqualTo("차 이름: sienna, 거리: " + INITIAL_DISTANCE);
    }

    @Test
    void 자동차는_Dto_로_변환될_수_있다() {
        List<Car> cars = List.of(new Car("sienna"), new Car("bryan"));
        List<CarInfo> carInfos = CarInfo.of(cars);

        assertThat(carInfos.get(0).getName()).isEqualTo("sienna");
        assertThat(carInfos.get(1).getName()).isEqualTo("bryan");
        assertThat(carInfos.get(0).getDistance()).isEqualTo(INITIAL_DISTANCE);
        assertThat(carInfos.get(1).getDistance()).isEqualTo(INITIAL_DISTANCE);
    }
}
