package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.dto.CarResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("가장 멀리 간 자동차들을 우승자로 판별한다.")
    void selectWinners() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(() -> true);
        car2.move(() -> false);
        car3.move(() -> true);

        Cars cars = new Cars(List.of(car1, car2, car3));
        assertThat(cars.selectWinners()).isEqualTo(List.of(CarResponse.of(car1), CarResponse.of(car3)));
    }

}