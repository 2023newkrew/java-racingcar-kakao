package car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingPlayerTest {

    RacingPlayer rc;

    @BeforeEach
    void init() {
        rc = new Car("Tester");
    }

    @Test
    void proceedNextTurnTest_forwardSuccess() {
        String prevOutput = rc.toString();
        rc.proceedNextTurn(true);
        Assertions.assertThat(rc.toString()).isEqualTo(prevOutput + "-");
    }

    @Test
    void proceedNextTurnTest_forwardFail() {
        String prevOutput = rc.toString();
        rc.proceedNextTurn(false);
        Assertions.assertThat(rc.toString()).isEqualTo(prevOutput);
    }
}
