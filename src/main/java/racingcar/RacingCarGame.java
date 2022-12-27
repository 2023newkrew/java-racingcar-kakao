package racingcar;

import java.util.List;

public class RacingCarGame {

    private List<Car> cars;
    private int count;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingCarGame(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.count = gameCount;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void play() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateBetweenZeroAndNine());
        }
        count--;
    }

    public boolean isFinish() {
        return count == 0;
    }
}
