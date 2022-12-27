package racing.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.exception.ErrorCode;
import racing.exception.RacingException;

import static org.assertj.core.api.Assertions.*;

public class RacingValidatorTest {
    private final RacingValidator racingValidator;

    RacingValidatorTest() {
        racingValidator = new RacingValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "ccc"})
    public void givenNormalCarName_whenCarNameValidate_thenOk(String input) {
        assertThatNoException().isThrownBy(() -> racingValidator.carNameValidate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    public void givenNullOrEmptyCarName_whenCarNameValidate_thenThrowException(String input){
        assertThatThrownBy(() -> racingValidator.carNameValidate(input))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.EMPTY_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "verylongcarname",
            "sixsix",
    })
    public void givenLongCarName_whenCarNameValidate_thenThrowException(String input){
        assertThatThrownBy(() -> racingValidator.carNameValidate(input))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.TOO_LONG_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -99})
    public void givenNegativeAttempt_whenAttemptValidate_thenThrowException(Integer attempt){
        assertThatThrownBy(() -> racingValidator.attemptValidate(attempt))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.NEGATIVE_ATTEMPT.getMessage());
    }
}
