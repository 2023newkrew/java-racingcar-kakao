package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domain.model.RacingCar;
import racingcar.domain.model.impl.RacingCarImpl;
import racingcar.exception.BusinessException;
import racingcar.exception.ErrorCode;

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
    void emptyOrNullCarName(String name) {
        Assertions.assertThatExceptionOfType(BusinessException.class)
                .isThrownBy(() -> new RacingCarImpl(name))
                .withMessage(ErrorCode.EMPTY_CAR_NAME_EXCEPTION.getMessage());
    }

    @Test
    void tooLongCarName() {
        String tooLongCarName = "too_long_car";
        Assertions.assertThatExceptionOfType(BusinessException.class)
                .isThrownBy(() -> new RacingCarImpl(tooLongCarName))
                .withMessage(ErrorCode.TOO_LONG_CAR_NAME_EXCEPTION.getMessage());
    }
}
