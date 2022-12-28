package car_racing;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final List<RacingPlayer> racingPlayers;
    private String[] playerNames;
    private Integer numberOfTurns;

    public RacingController() {
        racingPlayers = new ArrayList<>();
        inputView = new InputView();
    }

    public void run() {
        try {
            getNamesFromUser();
            getNumberOfTurnsFromUser();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return;
        }
        createPlayers();
        printResult();
    }

    private void getNamesFromUser() {
        OutputView.askForNames();
        playerNames = inputView.getPlayerNames();
    }

    private void getNumberOfTurnsFromUser() {
        OutputView.askForNumberOfTurns();
        numberOfTurns = inputView.getNumberOfTurns();
    }

    private void printResult() {
        System.out.println();
        System.out.println("실행결과");
        OutputView.printCurrentStatus(racingPlayers);
        for (int i = 0; i < numberOfTurns; i++) {
            sleep();
            runSingleTurn();
            OutputView.printCurrentStatus(racingPlayers);
        }
        OutputView.printWinners(GameRule.getWinners(racingPlayers));
    }

    private void createPlayers() {
        for (String playerName : playerNames) {
            racingPlayers.add(new Car(playerName));
        }
    }

    private void runSingleTurn() {
        for (RacingPlayer player : racingPlayers) {
            boolean proceed = GameRule.isAbleToProceed();
            player.proceedNextTurn(proceed);
        }
    }
    
    private void sleep() {
        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
