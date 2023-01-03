package carracing.domain;

public class TurnNumber {
    private final int turnNumber;
    private static final int MIN_TURN_NUM = 1;

    public TurnNumber(int turnNumber) {
        validateTurnNumber(turnNumber);
        this.turnNumber = turnNumber;
    }

    private void validateTurnNumber(int turnNumber) {
        if (turnNumber < MIN_TURN_NUM) {
            throw new RuntimeException("Invalid number for turns");
        }
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}
