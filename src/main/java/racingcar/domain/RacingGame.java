package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.List;

public class RacingGame {

    private final MovingStrategy movingStrategy;
    private int roundCount;
    private final CarsManager carsManager;

    public RacingGame(MovingStrategy movingStrategy, CarsManager carsManager, int roundCount) {
        this.movingStrategy = movingStrategy;
        this.carsManager = carsManager;
        this.roundCount = roundCount;
    }

    public boolean isEnd() {
        return this.roundCount == 0;
    }

    public CarsManager getCars() {
        return carsManager;
    }

    public List<String> getWinners() {
        return carsManager.findWinners();
    }

    public void race() {
        this.roundCount--;
        moveCars(movingStrategy);
    }

    private void moveCars(MovingStrategy movingStrategy) {
        carsManager.moveAll(movingStrategy);
    }
}
