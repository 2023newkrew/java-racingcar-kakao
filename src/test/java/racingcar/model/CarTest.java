package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차 이름은 1글자 이상 5글자 이하여야한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "       ", ""})
    void inputUnderFiveLength(String carName) {
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특정 값 이상인 경우 자동차를 이동시킨다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveCar(int moveValue) {
        Car car = new Car("a");

        car.move(moveValue);
        assertThat(car.getPosition()).isOne();
    }

    @DisplayName("특정 값 이하인 경우 자동차를 정지시킨다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopCar(int moveValue) {
        Car car = new Car("a");

        car.move(moveValue);
        assertThat(car.getPosition()).isZero();
    }
}
