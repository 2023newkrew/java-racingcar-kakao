package carracing;

import carracing.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingPlayerTest {

    @DisplayName("전진 성공")
    @Test
    void proceedNextTurnTest_forwardSuccess() {
        //given
        int initialPosition = 2;
        Car racingPlayer = new Car("Tester", initialPosition);
        //when
        racingPlayer.proceedNextTurn(true);
        //then
        Assertions.assertThat(racingPlayer.getPosition()).isEqualTo(initialPosition + 1);
    }

    @DisplayName("전진 실패")
    @Test
    void proceedNextTurnTest_forwardFail() {
        //given
        int initialPosition = 2;
        Car racingPlayer = new Car("Tester", initialPosition);
        //when
        racingPlayer.proceedNextTurn(false);
        //then
        Assertions.assertThat(racingPlayer.getPosition()).isEqualTo(initialPosition);
    }
}
