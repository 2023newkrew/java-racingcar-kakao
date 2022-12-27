package car_racing;

public class GameRule {

    private GameRule() {}

    private static final Integer STANDARD_SCORE = 4;

    private static final GamePlayStrategy gp = new RandomPlayStrategy();

    public static Boolean isAbleToProceed() {
        return gp.generateScore() >= STANDARD_SCORE;
    }
}
