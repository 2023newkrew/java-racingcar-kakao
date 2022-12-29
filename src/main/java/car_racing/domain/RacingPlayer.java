package car_racing.domain;

public interface RacingPlayer {
    void proceedNextTurn(Boolean proceed);
    Integer getPosition();
    String getName();
}
