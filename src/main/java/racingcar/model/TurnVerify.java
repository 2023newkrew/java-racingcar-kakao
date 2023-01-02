package racingcar.model;

public class TurnVerify {
    private static final int MAX_TURN = 1000;
    public static void verifyTurn(int turn) {
        if (turn < 1) {
            throw new IllegalArgumentException("turn should be positive integer");
        }

        if (turn > MAX_TURN) {
            throw new IllegalArgumentException("turn should be MAX_TURN or under");
        }
    }
}
