package car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamePlayStrategyTest {

    GamePlayStrategy[] gamePlayStrategies;
    int minScore, maxScore;

    @BeforeEach
    void init() {
        gamePlayStrategies = new GamePlayStrategy[] {
                new RandomPlayStrategy()
        };
        minScore = 0;
        maxScore = 9;
    }

    @Test
    void genrateScoreTest() {
        for (GamePlayStrategy gp:
             gamePlayStrategies) {
            Assertions.assertThat(gp.generateScore()).isBetween(minScore, maxScore);
        }
    }
}
