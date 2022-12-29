package racingcar;

import racingcar.model.RacingGame;
import racingcar.view.IO;

public class Controller {

    private IO io;

    public Controller() {
        this.io = new IO();
    }

    public void start() {
        RacingGame game = new RacingGame(io.inputCarNames());
        int turnIteration = io.inputTurnIteration();

        io.outputGameResultMessage();
        io.outputTurnResult(game.getCars());
        for (int i = 0; i < turnIteration; i++) {
            game.proceedTurn();
            io.outputTurnResult(game.getCars());
        }
        io.outputWinners(game.getFarthestCars());
    }
}
