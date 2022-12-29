package car_racing;

import car_racing.domain.RandomScoreStrategy;
import car_racing.domain.ScoreStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreStrategyTest {

    ScoreStrategy[] scoreStrategies;
    int minScore, maxScore;

    @BeforeEach
    void init() {
        scoreStrategies = new ScoreStrategy[] {
                new RandomScoreStrategy()
        };
        minScore = 0;
        maxScore = 9;
    }

    @Test
    void generateScoreTest() {
        for (ScoreStrategy ss : scoreStrategies) {
            Assertions.assertThat(ss.generateScore()).isBetween(minScore, maxScore);
        }
    }
}
