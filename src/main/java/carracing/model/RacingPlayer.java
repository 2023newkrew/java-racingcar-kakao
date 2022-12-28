package carracing.model;

public interface RacingPlayer {
    void proceedNextTurn(Boolean proceed);
    Integer getScore();
    String getName();
}
