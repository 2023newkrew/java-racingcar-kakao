package racingcar.controller;

import racingcar.domain.Cars;
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
        Integer numberOfGames = racingGameInputView.getNumberOfGames();

        Cars cars = new Cars(carNames);

        for (int i = 0; i < numberOfGames; i++) {
            cars.move();
            racingGameOutputView.printCars(cars);
        }

        racingGameOutputView.printWinners(cars.findWinners());
    }
}
