package carracing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingPlayer> racingPlayers;
    private int curTurn = 0;
    private final int numberOfTurns;

    public RacingGame(List<RacingPlayer> racingPlayers, int numberOfTurns) {
        this.racingPlayers = racingPlayers;
        InputVerifier.verifyNumberIsPos(numberOfTurns);
        this.numberOfTurns = numberOfTurns;
    }

    public List<RacingPlayer> getRacingPlayers() {
        return racingPlayers;
    }

    public void runSingleTurn() {
        for (RacingPlayer player : racingPlayers) {
            boolean proceed = GameRule.isAbleToProceed();
            player.proceedNextTurn(proceed);
        }
        this.curTurn++;
    }

    public List<RacingPlayer> getWinners() {
        Integer maxPosition = racingPlayers.stream()
                .mapToInt(RacingPlayer::getPosition)
                .max()
                .orElse(0);

        return racingPlayers.stream()
                .filter(p -> Objects.equals(p.getPosition(), maxPosition))
                .collect(Collectors.toList());
    }

    public Boolean isFinished() {
        return curTurn == numberOfTurns;
    }
}
