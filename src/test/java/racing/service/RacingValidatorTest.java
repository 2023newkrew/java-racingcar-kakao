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
    public void 정상적인_Car_이름이_입력되면_예외가_반환되지_않음(String input) {
        assertThatNoException().isThrownBy(() -> racingValidator.carNameValidate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "    "})
    public void Car_이름으로_빈문자열이_입력되면_예외를_반환(String input){
        assertThatThrownBy(() -> racingValidator.carNameValidate(input))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.EMPTY_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "verylongcarname",
            "sixsix",
    })
    public void 다섯자_이상의_Car_이름이_입력되면_예외를_반환(String input){
        assertThatThrownBy(() -> racingValidator.carNameValidate(input))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.TOO_LONG_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -99})
    public void 시도횟수로_음수가_입력되면_예외를_반환(Integer attempt){
        assertThatThrownBy(() -> racingValidator.attemptValidate(attempt))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.NEGATIVE_ATTEMPT.getMessage());
    }
}
