package racingcar.models;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final Integer maxCount;
    private final NumberGenerator numberGenerator;

    private int currentCount;

    public RacingGame(List<Car> cars, Integer maxCount, NumberGenerator numberGenerator) {
        this.cars = checkCars(cars);
        this.maxCount = maxCount;
        this.numberGenerator = numberGenerator;
        this.currentCount = 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Winner getWinners() {
        return new Winner(cars);
    }

    private List<Car> checkCars(List<Car> cars) {
        if (cars.size() < 2) {
            throw new RuntimeException("자동차는 2대 이상이어야 합니다.");
        }
        return cars;
    }

    public boolean isEnd() {
        return currentCount >= maxCount;
    }

    public void race() {
        if (isEnd()) {
            throw new RuntimeException("이미 종료된 경주입니다.");
        }
        cars.forEach((car) -> car.moveWithPower(numberGenerator.generateNumber()));
        currentCount++;
    }
}
