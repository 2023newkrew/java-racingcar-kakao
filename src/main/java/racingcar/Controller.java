package racingcar;

import racingcar.model.RacingGame;
import racingcar.view.IO;
import racingcar.view.Input;
import racingcar.view.Output;

public class Controller {

    private Input input;
    private Output output;

    public Controller() {
        this.input = new Input();
        this.output = new Output();
    }

    public void start() {
        RacingGame game = new RacingGame(input.getCarNames());
        int turnIteration = input.getTurnIteration();

        output.sendGameResultMessage();
        output.sendTurnResult(game.getCars());
        for (int i = 0; i < turnIteration; i++) {
            game.proceedTurn();
            output.sendTurnResult(game.getCars());
        }
        output.sendWinners(game.getFarthestCars());
    }
}
