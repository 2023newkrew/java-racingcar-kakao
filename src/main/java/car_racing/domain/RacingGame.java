package car_racing.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    private final List<RacingPlayer> racingPlayers = new ArrayList<>();
    private int curTurn = 0;
    private final int numberOfTurns;

    public RacingGame(String stringOfNames, int numberOfTurns) {
        String[] playerNames = StringParser.parse(stringOfNames);
        createPlayers(playerNames);
        InputVerifier.verifyNumberIsPos(numberOfTurns);
        this.numberOfTurns = numberOfTurns;
    }

    private void createPlayers(String[] playerNames) {
        for (String playerName : playerNames) {
            racingPlayers.add(new Car(playerName));
        }
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

    public RacingPlayer[] getWinners() {
        Integer maxPosition = racingPlayers.stream()
                .max(Comparator.comparingInt(RacingPlayer::getPosition))
                .get()
                .getPosition();

        return racingPlayers.stream()
                .filter(p -> Objects.equals(p.getPosition(), maxPosition))
                .toArray(RacingPlayer[]::new);
    }

    public Boolean isFinished() {
        return curTurn == numberOfTurns;
    }
}
