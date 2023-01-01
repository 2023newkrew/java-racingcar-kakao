import carracing.domain.CarCreator;
import carracing.domain.RacingGame;
import carracing.domain.StringParser;
import carracing.view.InputView;
import carracing.view.OutputView;


public class Application {
    public static void main(String[] args) {
        StringParser stringParser = new StringParser();
        CarCreator carCreator = new CarCreator(stringParser);
        RacingGame racingGame = new RacingGame(carCreator.createCars(InputView.getPlayerNames()), InputView.getNumberOfTurns());

        OutputView.printInitialStatus(racingGame.getRacingPlayers());
        while (!racingGame.isFinished()) {
            racingGame.runSingleTurn();
            OutputView.printCurrentStatus(racingGame.getRacingPlayers());
        }

        OutputView.printWinners(racingGame.getWinners());
    }
}
