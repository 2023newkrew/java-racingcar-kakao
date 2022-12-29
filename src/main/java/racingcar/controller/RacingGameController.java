package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.InputParser;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

public class RacingGameController {
    private final RacingGameInputView racingGameInputView;
    private final RacingGameOutputView racingGameOutputView;

    public RacingGameController() {
        this.racingGameInputView = new RacingGameInputView();
        this.racingGameOutputView = new RacingGameOutputView();
    }

    public void run() {
        String carNames = racingGameInputView.getCarNames();
        Integer numberOfGames = racingGameInputView.getNumberOfGames();

        InputParser inputParser = new InputParser();

        Cars cars = new Cars(inputParser.splitNames(carNames));
        for (int i = 0; i < numberOfGames; i++) {
            cars.move();
            racingGameOutputView.printCars(cars);
        }
        racingGameOutputView.printWinners(cars.findWinners());
    }
}
