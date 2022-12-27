package car_racing.model;

public interface RacingPlayer {
    void proceedNextTurn(Boolean proceed);
    Integer getScore();
    String getName();
}
