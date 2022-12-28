package racingcar;

public class RacingGameRunner {
    private final String carNames;
    private final int numberOfGames;

    public RacingGameRunner(final String carNames, final int numberOfGames) {
        this.carNames = carNames;
        this.numberOfGames = numberOfGames;
    }

    public void run() {
        InputParser inputParser = new InputParser();

        Cars cars = new Cars(inputParser.splitNames(carNames));
        for (int i = 0; i < numberOfGames; i++) {
            cars.move();
            cars.printCars();
            System.out.println();
        }
        cars.printWinners();
    }
}
