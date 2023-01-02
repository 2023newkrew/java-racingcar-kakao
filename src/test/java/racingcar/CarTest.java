package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MoveState;

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

    @Test
    @DisplayName("자동차의 동작 상태가 FORWARD이면 전진한다.")
    void carForward() {
        Car car = new Car("davi");
        car.forward(()->MoveState.FORWARD);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차의 동작 상태가 STOP이면 정지한다.")
    void carStop() {
        Car car = new Car("davi");
        car.forward(()->MoveState.STOP);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
