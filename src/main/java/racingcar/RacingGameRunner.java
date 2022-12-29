package racingcar;

import racingcar.view.RacingGameOutputView;

public class RacingGameRunner {
    private final String carNames;
    private final int numberOfGames;

    public RacingGameRunner(final String carNames, final int numberOfGames) {
        this.carNames = carNames;
        this.numberOfGames = numberOfGames;
    }

    public void run() {
        RacingGameOutputView racingGameOutputView = new RacingGameOutputView();
        InputParser inputParser = new InputParser();

        Cars cars = new Cars(inputParser.splitNames(carNames));
        for (int i = 0; i < numberOfGames; i++) {
            cars.move();
            racingGameOutputView.printCars(cars);
        }
        racingGameOutputView.printWinners(cars.findWinners());
    }
}
