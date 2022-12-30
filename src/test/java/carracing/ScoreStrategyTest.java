package carracing;

import carracing.domain.RandomScoreStrategy;
import carracing.domain.ScoreStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("랜덤 수 0~9 사이 반환")
    @Test
    void generateScoreTest() {
        for (ScoreStrategy ss : scoreStrategies) {
            Assertions.assertThat(ss.generateScore()).isBetween(minScore, maxScore);
        }
    }
}
