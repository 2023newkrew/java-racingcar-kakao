package racingcar.racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.racing.RacingTurn;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingTurnTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void invalidRacingTurn(int turn) {
        assertThat(RacingTurn.isValidTurn(turn)).isFalse();
    }

    @Test
    void validRacingTurn() {
        assertThat(new RacingTurn("10")).isEqualTo(new RacingTurn("10"));
    }

    @Test
    void proceedTurn() {
        RacingTurn racingTurn = new RacingTurn("10");
        racingTurn.proceed();

        assertThat(racingTurn).isEqualTo(new RacingTurn("9"));
    }

    @Test
    void isEnd() {
        RacingTurn racingTurn = new RacingTurn("1");

        assertThat(racingTurn.isEnd()).isFalse();

        racingTurn.proceed();

        assertThat(racingTurn.isEnd()).isTrue();
    }
}
