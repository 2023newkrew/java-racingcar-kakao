package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    void move() {
        Car car = new Car("aa");

        CarDTO beforeMoveCarDto = car.toDTO();
        car.move(CarAction.FORWARD);
        CarDTO afterMoveCarDto = car.toDTO();

        assertThat(afterMoveCarDto.getPosition()).isEqualTo(beforeMoveCarDto.getPosition() + 1);
    }

    @DisplayName("자동차 이름은 5자 이하여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"asd", "aa", "zzxdc", "as"})
    void nameShouldBeUnderLengthFive(String name) {
        assertThatCode(() -> new Car(name)).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 5자를 초과하면 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaagsa", "aaaaaz"})
    void nameShouldNotBeOverLengthFive(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 공백이거나 비어있으면 에러를 발생시킨다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void nameShouldNotBeBlankOrNull(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
