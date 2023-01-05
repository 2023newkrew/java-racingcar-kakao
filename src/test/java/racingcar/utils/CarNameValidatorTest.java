package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameValidatorTest {

    @Test
    void validateRacingCarNames() {
        // given
        String carNames[] = {"car1", "car2", "car3"};

        // then
        assertDoesNotThrow(() -> CarNameValidator.validateRacingCarNames(carNames));
    }

    @Test
    void validateRacingCarNames_longName() {
        // given
        String carNames[] = {"car1", "car22222222", "car3"};

        // then
        assertThatThrownBy(() -> CarNameValidator.validateRacingCarNames(carNames));
    }

    @Test
    void validateRacingCarNames_blank() {
        // given
        String carNames[] = {"car1", "", "car3"};

        // then
        assertThatThrownBy(() -> CarNameValidator.validateRacingCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRacingCarNames_singleCar() {
        // given
        String carNames[] = {"car1"};

        // then
        assertDoesNotThrow(() -> CarNameValidator.validateRacingCarNames(carNames));
    }
}
