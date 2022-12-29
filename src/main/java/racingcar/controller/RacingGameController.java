package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.NumberOfGames;
import racingcar.domain.RacingGame;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameInputView racingGameInputView;
    private final RacingGameOutputView racingGameOutputView;

    public RacingGameController() {
        this.racingGameInputView = new RacingGameInputView();
        this.racingGameOutputView = new RacingGameOutputView();
    }

    public void run() {
        List<String> carNames = racingGameInputView.getCarNames();
        int numberOfGames = racingGameInputView.getNumberOfGames();

        RacingGame racingGame = new RacingGame(carNames, numberOfGames);

        while(!racingGame.isGameEnd()) {
            racingGame.move();
            racingGameOutputView.printCars(racingGame.getCars());
        }

        racingGameOutputView.printWinners(racingGame.findWinners());
    }
}
