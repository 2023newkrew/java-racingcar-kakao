package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("자동차의 이름은 1~5자 사이어야 한다.")
    void carNameLength() {
        assertThatCode(()->{
            new Car("davi");
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차의 이름이 없거나 5자 초과인 경우 에러를 던진다")
    void carNameLengthMoreThan5() {
        assertThatThrownBy(()->{
            new Car("asdfasdf");
        }).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()->{
            new Car("");
        }).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()->{
            new Car(null);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,})
    @DisplayName("랜덤 숫자가 3 이하면 자동차가 정지한다.")
    void carStop(int power) {
        Car car = new Car("davi");
        car.forward(power);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("랜덤 숫자가 4 이상이면 자동차가 전진한다.")
    void carForwardingWithHooking(int power) {
        Car car = new Car("davi") {
            @Override
            protected int getRandomNumber() {
                return power;
            }
        };
        car.forward();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("랜덤 숫자가 3 이하면 자동차가 정지한다.")
    void carStopWithHooking(int power) {
        Car car = new Car("davi") {
            @Override
            protected int getRandomNumber() {
                return power;
            }
        };
        car.forward();
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
