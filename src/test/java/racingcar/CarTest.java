package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    void moveCar() {
        Car car = new Car("dummy");
        int prevPosition = car.getPosition();
        car.move();
        Assertions.assertThat(car.getPosition())
                .isEqualTo(prevPosition + 1);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "abcdef"})
    void invalidName(String name) {
        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    Car car = new Car(name);
                });
    }
}
