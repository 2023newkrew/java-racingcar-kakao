package carracing.domain;

public interface RacingPlayer {
    void proceedNextTurn(Boolean proceed);
    Integer getPosition();
    String getName();
}
