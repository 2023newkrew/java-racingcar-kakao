package carracing.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> racingPlayers;
    private int curTurn = 0;
    private final int numberOfTurns;

    public RacingGame(List<Car> racingPlayers, int numberOfTurns) {
        this.racingPlayers = racingPlayers;
        InputVerifier.verifyNumberIsPos(numberOfTurns);
        this.numberOfTurns = numberOfTurns;
    }

    public List<Car> getRacingPlayers() {
        return racingPlayers;
    }

    public void runSingleTurn() {
        for (Car player : racingPlayers) {
            boolean proceed = GameRule.isAbleToProceed();
            player.proceedNextTurn(proceed);
        }
        this.curTurn++;
    }

    public List<Car> getWinners() {
        Integer maxPosition = racingPlayers.stream()
                .mapToInt(Car::getPosition)
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
