package racingcar;

import racingcar.model.RacingGame;
import racingcar.view.Input;
import racingcar.view.Output;

public class Controller {
    public void start() {
        RacingGame game = new RacingGame(Input.getCarNames());
        int turnIteration = Input.getTurnIteration();

        Output.displayGameResultMessage();
        Output.displayTurnResult(game.getCars());
        for (int i = 0; i < turnIteration; i++) {
            game.proceedTurn();
            Output.displayTurnResult(game.getCars());
        }
        Output.displayWinners(game.getFarthestCars());
    }
}
