package racingcar.engine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.NumberGenerator;

public class RacingGame {
    private final List<Car> cars;
    private final Integer maxCount;
    private final NumberGenerator numberGenerator;

    private int currentCount;

    public RacingGame(List<Car> cars, Integer maxCount, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.maxCount = maxCount;
        this.numberGenerator = numberGenerator;
        this.currentCount = 0;
    }

    public List<Car> getWinners() {
        return cars.stream().filter((car) -> car.throughSpecificPoint(getMaxPosition())).collect(Collectors.toList());
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

    private int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }
}
