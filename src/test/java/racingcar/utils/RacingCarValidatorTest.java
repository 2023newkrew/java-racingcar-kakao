package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarValidatorTest {

    private RacingCarValidator racingCarValidator;

    @BeforeEach
    void setUp() {
        racingCarValidator = new RacingCarValidator();
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 경우 예외가 발생하다.")
    void validateCarName() {
        String[] inValidCarNames = { "avante", "sonata" };

        assertThatThrownBy(() -> racingCarValidator.validateCarNames(inValidCarNames))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("시도할 횟수가 1회 미만일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -2, -3 })
    void validateGameRound(int gameRound) {
        assertThatThrownBy(() -> racingCarValidator.validateGameRound(gameRound))
                .isInstanceOf(RuntimeException.class);
    }

}
