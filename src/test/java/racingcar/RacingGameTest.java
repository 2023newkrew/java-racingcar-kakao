package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RacingGameTest {

    @Test
    void create_racing_game_test() {
        String carNames = "pobi,crong,honux";
        int roundToPlay = 5;

        assertDoesNotThrow(() -> new RacingGame(carNames, roundToPlay, new RandomNumberSelector(0, 10)));
    }

    @Test
    void check_winners_test() {
        String carNames = "pobi,crong,honux";
        int roundToPlay = 2;

        RacingGame racingGame = new RacingGame(carNames, roundToPlay, new MoveNumberSelector());

        Optional<List<String>> gameWinnersResult0 = racingGame.checkWinners();
        assertThat(gameWinnersResult0).isEmpty();

        racingGame.proceedGame();
        Optional<List<String>> gameWinnersResult1 = racingGame.checkWinners();
        assertThat(gameWinnersResult1).isEmpty();

        racingGame.proceedGame();
        Optional<List<String>> gameWinnersResult2 = racingGame.checkWinners();
        assertThat(gameWinnersResult2).isPresent();
        assertThat(gameWinnersResult2.get().get(0)).isEqualTo("pobi");
        assertThat(gameWinnersResult2.get().get(1)).isEqualTo("crong");
        assertThat(gameWinnersResult2.get().get(2)).isEqualTo("honux");
    }
}
