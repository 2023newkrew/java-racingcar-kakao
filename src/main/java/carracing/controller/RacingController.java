package carracing.controller;

import carracing.common.exception.InvalidInputFormatException;
import carracing.model.Car;
import carracing.model.GameRule;
import carracing.model.RacingPlayer;
import carracing.view.InputView;
import carracing.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController implements GameController {
    private final InputView inputView = new InputView();
    private List<RacingPlayer> racingPlayers;
    private Integer numberOfTurns;

    public void run() {
        try {
            createPlayers(getNamesFromUser());
            getNumberOfTurnsFromUser();
        } catch (InvalidInputFormatException e) {
            System.out.println(e.getLocalizedMessage());
            return;
        }

        runWholeGame();
    }
    private List<String> getNamesFromUser() {
        OutputView.askForNames();
        return inputView.getPlayerNames();
    }

    private void getNumberOfTurnsFromUser() {
        OutputView.askForNumberOfTurns();
        numberOfTurns = inputView.getNumberOfTurns();
    }

    private void runWholeGame() {
        OutputView.printResultTitle();
        OutputView.printCurrentStatus(racingPlayers);
        for (int i = 0; i < numberOfTurns; i++) {
            sleepForMillis(500);
            runSingleTurn();
            OutputView.printCurrentStatus(racingPlayers);
        }

        printResult(racingPlayers);
    }

    private void printResult(List<RacingPlayer> racingPlayers) {
        List<RacingPlayer> winners;

        try {
            winners = GameRule.getWinners(racingPlayers);
        } catch (InvalidInputFormatException e) {
            System.out.println(e.getLocalizedMessage());
            return;
        }
        OutputView.printWinners(winners);
    }

    private void createPlayers(List<String> playerNames) {
        racingPlayers = playerNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private void runSingleTurn() {
        racingPlayers
            .forEach(racingPlayer -> racingPlayer.proceedNextTurn(GameRule.isAbleToProceed()));
    }
    
    private void sleepForMillis(Integer milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch(InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
