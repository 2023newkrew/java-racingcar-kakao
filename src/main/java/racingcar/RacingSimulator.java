package racingcar;

import java.util.List;

public class RacingSimulator {

    private final int maxTryCount;
    private final Cars cars;
    private int tryCount;

    public RacingSimulator(int maxTryCount, Cars cars) {
        this.maxTryCount = maxTryCount;
        this.tryCount = 0;
        this.cars = cars;
    }

    public void move() {
        if(isNotTryable()){
            throw new IllegalStateException();
        }

        cars.move();
        tryCount++;
    }

    private boolean isNotTryable() {
        return tryCount >= maxTryCount;
    }

    public Result getResult() {
        return cars.getResult();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
