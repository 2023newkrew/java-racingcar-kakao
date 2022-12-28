package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    Car car;
    int prevPosition;

    @BeforeEach
    void setUp() {
        car = new Car("dummy");
        prevPosition = car.getPosition();
    }

    @Test
    void moveCar() {
        car.move(4);
        Assertions.assertThat(car.getPosition())
                .isEqualTo(prevPosition + 1);
    }

    @Test
    void dontMoveCar() {
        car.move(3);
        Assertions.assertThat(car.getPosition())
                .isEqualTo(prevPosition);
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
