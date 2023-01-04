package racingcar.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.step2.domain.RacingGame;

import java.util.List;

public class RacingGameTest {

    @Test
    void createCarTest() {
        RacingGame racingGame = new RacingGame(List.of("car1", "car2", "car3"), 5);

        Assertions.assertThat(racingGame.getCars().getCarList().size()).isEqualTo(3);
    }

}
