package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int INITIAL_DISTANCE = 1;
    private static final int MOVE_STANDARD = 4;

    @Test
    void 자동자_생성시_주어진_이름과_초기_거리를_가진다() {
        Car car = new Car("bryan");

        assertThat(car.getName()).isEqualTo("bryan");
        assertThat(car.getDistance()).isEqualTo(INITIAL_DISTANCE);
    }

    @ValueSource(ints = {0,1,2,3,4})
    @ParameterizedTest
    void 자동차는_값이_기준_이상이면_한_칸_전진한다(int number) {
        Car car = new Car("new_car");
        int beforeDistance = car.getDistance();

        car.move(MOVE_STANDARD+number);

        assertThat(car.getDistance()).isEqualTo(beforeDistance+1);
    }

    @ValueSource(ints = {0,1,2,3,4})
    @ParameterizedTest
    void 자동차는_값이_기준_미만이면_전진하지_않는다(int number) {
        Car car = new Car("new_car");
        int beforeDistance = car.getDistance();

        car.move(MOVE_STANDARD-1-number);

        assertThat(car.getDistance()).isEqualTo(beforeDistance);
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
