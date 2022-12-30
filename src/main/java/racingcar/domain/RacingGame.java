package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final NumberOfGames numberOfGames;

    public RacingGame(List<String> carNames, int numberOfGames) {
        this.cars = new Cars(carNames);
        this.numberOfGames = new NumberOfGames(numberOfGames);
    }

    public void move() {
        cars.move();
        numberOfGames.move();
    }

    public boolean isGameEnd() {
        return numberOfGames.isGameEnd();
    }

    public Cars getCars() {
        return cars;
    }

    public Winners findWinners() {
        return cars.findWinners();
    }
}
