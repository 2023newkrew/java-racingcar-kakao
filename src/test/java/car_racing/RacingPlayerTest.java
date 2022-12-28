package car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingPlayerTest {

    RacingPlayer[] players;

    @BeforeEach
    void init() {
        players = new RacingPlayer[]{
                new Car("Tester")
        };
    }

    @Test
    void proceedNextTurnTest_forwardSuccess() {
        for (RacingPlayer player : players) {
            String prevOutput = player.toString();
            player.proceedNextTurn(true);
            Assertions.assertThat(player.toString()).isEqualTo(prevOutput + "-");
        }
    }

    @Test
    void proceedNextTurnTest_forwardFail() {
        for (RacingPlayer player : players) {
            String prevOutput = player.toString();
            player.proceedNextTurn(false);
            Assertions.assertThat(player.toString()).isEqualTo(prevOutput);
        }
    }
}
