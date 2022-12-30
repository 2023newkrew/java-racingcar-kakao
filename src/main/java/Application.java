import carracing.domain.RacingGame;
import carracing.view.InputView;
import carracing.view.OutputView;

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
