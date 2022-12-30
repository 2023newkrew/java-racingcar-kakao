import car_racing.domain.RacingGame;
import car_racing.view.InputView;
import car_racing.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String inputString = InputView.getPlayerNames();
        Integer numberOfTurns = InputView.getNumberOfTurns();

        RacingGame racingGame = new RacingGame(inputString, numberOfTurns);

        OutputView.printInitialStatus(racingGame.getRacingPlayers());
        while (!racingGame.isFinished()) {
            racingGame.runSingleTurn();
            OutputView.printCurrentStatus(racingGame.getRacingPlayers());
        }

        OutputView.printWinners(racingGame.getWinners());
    }
}
