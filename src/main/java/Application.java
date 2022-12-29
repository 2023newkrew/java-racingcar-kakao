import car_racing.domain.RacingGame;
import car_racing.view.InputView;
import car_racing.view.OutputView;

public class Application {
    public static void main(String[] args) {

//        StringParser parser = new StringParser();
//        CalculatorRunner runner = new CalculatorRunner(parser);
//
//        runner.run();

        String[] playerNames = InputView.getPlayerNames();
        Integer numberOfTurns = InputView.getNumberOfTurns();

        RacingGame racingGame = new RacingGame(playerNames, numberOfTurns);

        OutputView.printInitialStatus(racingGame.getRacingPlayers());
        while (!racingGame.isFinished()) {
            racingGame.runSingleTurn();
            OutputView.printCurrentStatus(racingGame.getRacingPlayers());
        }

        OutputView.printWinners(racingGame.getWinners());
    }
}
