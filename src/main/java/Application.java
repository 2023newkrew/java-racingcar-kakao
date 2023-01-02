import carracing.domain.CarCreator;
import carracing.domain.Cars;
import carracing.domain.RacingGame;
import carracing.domain.StringParser;
import carracing.view.InputView;
import carracing.view.OutputView;


public class Application {
    public static void main(String[] args) {
        StringParser stringParser = new StringParser();
        CarCreator carCreator = new CarCreator(stringParser);
        Cars cars = carCreator.createCars(InputView.getPlayerNames());
        RacingGame racingGame = new RacingGame(cars, InputView.getNumberOfTurns());
        OutputView.printInitialStatus(racingGame.getRacingPlayers());
        while (!racingGame.isFinished()) {
            racingGame.runSingleTurn();
            OutputView.printCurrentStatus(racingGame.getRacingPlayers());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
