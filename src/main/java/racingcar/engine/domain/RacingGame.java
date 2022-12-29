package racingcar.engine.domain;

import java.util.ArrayList;
import java.util.List;
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

    public List<String> getWinners() {
        int max = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            max = car.renewWinners(max, winners);
        }
        return winners;
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
