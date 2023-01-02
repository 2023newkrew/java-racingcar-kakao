package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TurnVerifyTest {
    @DisplayName("Throw exception when turn is negative integer")
    @ValueSource(ints = {-1, -2, -3, -4})
    @ParameterizedTest
    void negativeTurnTest(final int turn) {
        assertThatThrownBy(() -> TurnVerify.verifyTurn(turn))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Throw exception when turn is 0")
    @Test
    void zeroTurnTest() {
        assertThatThrownBy(() -> TurnVerify.verifyTurn(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
