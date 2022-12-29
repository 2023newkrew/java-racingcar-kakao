package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.model.RacingCar;

public class RacingCarTest {
    RacingCar racingCar;
    int prevPosition;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("dummy");
        prevPosition = racingCar.getPosition();
    }

    @Test
    void moveCar() {
        racingCar.move(4);
        Assertions.assertThat(racingCar.getPosition())
                .isEqualTo(prevPosition + 1);
    }

    @Test
    void dontMoveCar() {
        racingCar.move(3);
        Assertions.assertThat(racingCar.getPosition())
                .isEqualTo(prevPosition);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "abcdef"})
    void invalidName(String name) {
        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new RacingCar(name));
    }
}
