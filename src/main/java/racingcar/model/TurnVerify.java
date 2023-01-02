package racingcar.model;

public class TurnVerify {
    public static void verifyTurn(int turn) {
        if (turn < 1) {
            throw new IllegalArgumentException("turn should be positive integer");
        }
    }
}
