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
    @ValueSource(ints = {-1, -99})
    public void 시도횟수로_음수가_입력되면_예외를_반환(Integer attempt){
        assertThatThrownBy(() -> racingValidator.attemptValidate(attempt))
                .isInstanceOf(RacingException.class)
                .hasMessage(ErrorCode.NEGATIVE_ATTEMPT.getMessage());
    }
}
