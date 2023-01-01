package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.List;

public class RacingGame {

    private final MovingStrategy movingStrategy;
    private int roundCount;
    private final Cars cars;

    public RacingGame(MovingStrategy movingStrategy, Cars cars, int roundCount) {
        this.movingStrategy = movingStrategy;
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public boolean isEnd() {
        return this.roundCount == 0;
    }

    public Cars getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return cars.findWinners();
    }

    public void race() {
        this.roundCount--;
        moveCars(movingStrategy);
    }

    private void moveCars(MovingStrategy movingStrategy) {
        cars.moveAll(movingStrategy);
    }
}
