package carracing.domain;

public class GameRule {
    private static final Integer STANDARD_SCORE = 4;
    private static final ScoreStrategy SCORE_STRATEGY = new RandomScoreStrategy();

    private GameRule() {}

    public static Boolean isAbleToProceed() {
        return SCORE_STRATEGY.generateScore() >= STANDARD_SCORE;
    }
}
