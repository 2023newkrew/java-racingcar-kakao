package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    Car car;
    int prevPosition;
    private final static String CAR_DUMMY_STRING = "dummy";

    @BeforeEach
    void setUp() {
        car = new Car(CAR_DUMMY_STRING);
        prevPosition = car.getPosition();
    }

    @Test
    void moveCar() {
        car.move(4);
        assertEquals(car.getPosition(), ++prevPosition);
    }

    @Test
    void dontMoveCar() {
        car.move(3);
        assertEquals(car.getPosition(), prevPosition);
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
