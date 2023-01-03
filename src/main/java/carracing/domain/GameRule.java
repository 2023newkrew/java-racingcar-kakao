package carracing.domain;

public class GameRule {
    private static final Integer STANDARD_SCORE = 4;

    private GameRule() {}

    public static Boolean isAbleToProceed() {
        return generateRandomScore() >= STANDARD_SCORE;
    }

    private static Integer generateRandomScore() {
        return (int) (Math.random() * 9);
    }
}
