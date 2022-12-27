package car_racing.controller;

import car_racing.common.exception.InvalidInputFormatException;
import car_racing.model.Car;
import car_racing.model.GameRule;
import car_racing.model.RacingPlayer;
import car_racing.view.InputView;
import car_racing.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
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
        System.out.println();
        System.out.println("실행결과");
        OutputView.printCurrentStatus(racingPlayers);
        for (int i = 0; i < numberOfTurns; i++) {
            sleepForMillis(500);
            runSingleTurn();
            OutputView.printCurrentStatus(racingPlayers);
        }
        OutputView.printWinners(GameRule.getWinners(racingPlayers));
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
