package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("움직이는 조건이 참일 경우 차가 1칸 앞으로 움직여야 한다.")
    @Test
    void shouldMove() {
        Car car = new Car("aa");

        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("움직이는 조건이 거짓일 경우 차가 1칸 앞으로 움직여야 한다.")
    @Test
    void shouldNotMove() {
        Car car = new Car("aa");

        car.move(() -> false);
        assertThat(car.getPosition()).isZero();
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
