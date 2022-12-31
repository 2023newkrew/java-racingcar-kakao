import carracing.domain.RacingGame;
import carracing.domain.StringParser;
import carracing.view.InputView;
import carracing.view.OutputView;

public class Application {
    public static void main(String[] args) {
        StringParser stringParser = new StringParser();
        String inputString = InputView.getPlayerNames();
        Integer numberOfTurns = InputView.getNumberOfTurns();

        RacingGame racingGame = new RacingGame(stringParser, inputString, numberOfTurns);

        OutputView.printInitialStatus(racingGame.getRacingPlayers());
        while (!racingGame.isFinished()) {
            racingGame.runSingleTurn();
            OutputView.printCurrentStatus(racingGame.getRacingPlayers());
        }

        OutputView.printWinners(racingGame.getWinners());
    }
}
