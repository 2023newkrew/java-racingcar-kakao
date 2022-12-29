package racing;

import racing.domain.tactic.GameTacticStrategy;
import racing.domain.tactic.RandomTacticStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamePlayStrategyTest {

    GameTacticStrategy[] gamePlayStrategies;
    int minScore, maxScore;

    @BeforeEach
    void init() {
        gamePlayStrategies = new GameTacticStrategy[] {
                new RandomTacticStrategy()
        };
        minScore = 0;
        maxScore = 9;
    }

    @Test
    void genrateScoreTest() {
        for (GameTacticStrategy gp:
             gamePlayStrategies) {
            Assertions.assertThat(gp.generateScore()).isBetween(minScore, maxScore);
        }
    }
}
