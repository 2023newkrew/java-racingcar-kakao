package racingcar.domain.game;

public class RacingGameTurnInfo {
    private final int finalTurn;
    private int turnCount;

    public RacingGameTurnInfo(int finalTurn) {
        this.finalTurn = finalTurn;
        this.turnCount = 0;
    }

    public int getTurnCount() {
        return this.turnCount;
    }

    public boolean isFinished() {
        return this.turnCount >= this.finalTurn;
    }

    public void increaseTurnCount() {
        this.turnCount++;
    }

    public static void validateFinalTurnNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요.");
        }
    }
}
