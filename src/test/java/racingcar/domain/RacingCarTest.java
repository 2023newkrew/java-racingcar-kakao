package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domain.car.RacingCar;
import racingcar.domain.car.impl.RacingCarImpl;
import racingcar.exception.BusinessException;
import racingcar.exception.ErrorCode;

public class RacingCarTest {

    RacingCar racingCar;

    int prevPosition;

    @BeforeEach
    void setUp() {
        racingCar = new MockRacingCarImpl("lion");
        prevPosition = racingCar.getCarPosition();
    }

    @Test
    void moveCar() {
        racingCar.move();
        Assertions.assertThat(racingCar.getCarPosition())
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
