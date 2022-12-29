package car_racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<RacingPlayer> racingPlayers = new ArrayList<>();

    public RacingGame(String[] playerNames) {
        createPlayers(playerNames);
    }

    private void createPlayers(String[] playerNames) {
        for (String playerName : playerNames) {
            racingPlayers.add(new Car(playerName));
        }
    }

    public void runSingleTurn() {
        for (RacingPlayer player : racingPlayers) {
            boolean proceed = GameRule.isAbleToProceed();
            player.proceedNextTurn(proceed);
        }
    }
}
