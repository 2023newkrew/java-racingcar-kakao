package carracing;

import carracing.model.GamePlayerStrategy;
import carracing.model.RandomPlayerStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamePlayStrategyTest {

    GamePlayerStrategy[] gamePlayStrategies;
    int minScore, maxScore;

    @BeforeEach
    void init() {
        gamePlayStrategies = new GamePlayerStrategy[] {
                new RandomPlayerStrategy()
        };
        minScore = 0;
        maxScore = 9;
    }

    @Test
    void genrateScoreTest() {
        for (GamePlayerStrategy gp:
             gamePlayStrategies) {
            Assertions.assertThat(gp.generateScore()).isBetween(minScore, maxScore);
        }
    }
}
