package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.model.RacingCar;
import racingcar.domain.model.impl.RacingCarImpl;

public class RacingCarTest {

    RacingCar racingCar;

    int prevPosition;

    @BeforeEach
    void setUp() {
        racingCar = new MockRacingCarImpl("lion");
        prevPosition = racingCar.getPosition();
    }

    @Test
    void moveCar() {
        racingCar.move();
        Assertions.assertThat(racingCar.getPosition())
                .isEqualTo(prevPosition + 1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"too_long_name"})
    void invalidName(String name) {
        Assertions.assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new RacingCarImpl(name));
    }
}
