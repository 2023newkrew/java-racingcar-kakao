package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class CarTest {

    @DisplayName("이름이 5자 이하인 문자열에 대해서는 자동차 이름으로 활용하여 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"joel", "red", "jay", "nell"})
    void create_car_test(String possibleName) {
        Car car = new Car(possibleName);
        int position = car.getPosition();
        String carName = car.getCarName();

        assertThat(position).isZero();
        assertThat(carName).isEqualTo(possibleName);
    }

    @DisplayName("이름이 5자 초과 문자열에 대해서는 자동차 이름으로 활용할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"joeljoel", "redred", "jayjay", "nellnell"})
    void invalid_car_name_test(String invalidName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(invalidName))
                .withMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @DisplayName("이름이 공백의 문자열이거나, null이라면 자동차 이름으로 활용할 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void empty_or_null_name_test(String invalidName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Car(invalidName))
            .withMessage("자동차 이름은 최소 1자 이상이여야 합니다.");
    }

    @DisplayName("move 함수를 호출하면 자동차가 한 칸 나아갈 수 있다.")
    @Test
    void movement_test() {
        // given
        Car car = new Car("red");
        int beforeMove = car.getPosition();

        // when
        car.move();

        // then
        int afterMove = car.getPosition();
        int movement = afterMove - beforeMove;
        assertThat(movement).isEqualTo(1);
    }
}
