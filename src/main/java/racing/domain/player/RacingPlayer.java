package racing.domain.player;

public interface RacingPlayer {
    void proceedNextTurn(Boolean proceed);
    Integer getScore();
    String getName();
}
