package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("랜덤 숫자가 4 이상이면 자동차가 전진한다.")
    void carForwarding(int power) {
        Car car = new Car("davi");
        car.forward(power);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,})
    @DisplayName("랜덤 숫자가 3 이하면 자동차가 정지한다.")
    void carStop(int power) {
        Car car = new Car("davi");
        car.forward(power);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
