package racingcar.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void forward() {
        Car car = new Car("aa");

        CarDTO beforeMoveCarDto = car.toDTO();
        car.move(() -> CarAction.FORWARD);
        CarDTO afterMoveCarDto = car.toDTO();

        assertThat(afterMoveCarDto.getPosition()).isEqualTo(beforeMoveCarDto.getPosition() + 1);
    }

    @Test
    void stay() {
        Car car = new Car("aa");

        CarDTO beforeMoveCarDto = car.toDTO();
        car.move(() -> CarAction.STAY);
        CarDTO afterMoveCarDto = car.toDTO();

        assertThat(afterMoveCarDto.getPosition()).isEqualTo(beforeMoveCarDto.getPosition());
    }

    @ParameterizedTest
    @ValueSource(strings = {"aasd", "asssz", "zzz"})
    void validName(String name) {
        assertThat(Car.isValidName(name)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdasdasd", "azx1@!$", "afxvcx@3", "", " ", "ass "})
    void invalidName(String name) {
        assertThat(Car.isValidName(name)).isFalse();
    }
}
