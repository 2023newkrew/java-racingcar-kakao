package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @DisplayName("특정 값 이상인 경우 자동차를 이동시킨다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveForward(int value) {
        Car car = new Car("a");

        car.move(value);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("특정 값 이하인 경우 자동차를 정지시킨다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(int value) {
        Car car = new Car("a");

        car.move(value);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
