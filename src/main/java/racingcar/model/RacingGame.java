package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final int maxTryCount;
    private final Cars cars;
    private int tryCount;

    public RacingGame(int maxTryCount, NumberGenerator numberGenerator, List<String> names) {
        if (names.size() == 0) {
            throw new IllegalArgumentException("레이싱에 참가할 자동차는 1대 이상이여야 합니다.");
        }

        this.cars = createCars(numberGenerator, names);
        this.maxTryCount = maxTryCount;
        this.tryCount = 0;
    }

    private Cars createCars(NumberGenerator numberGenerator, List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(numberGenerator, cars);
    }

    public void move() {
        if (isFinished()) {
            throw new IllegalStateException("자동차 경주가 완료됐습니다.");
        }

        cars.move();
        tryCount++;
    }

    public boolean isFinished() {
        return tryCount >= maxTryCount;
    }

    public Winners getWinners() {
        if (isFinished()) {
            return cars.getWinners();
        }
        throw new IllegalStateException("자동차 경주가 끝나지 않았습니다.");
    }

    public Positions getPositions() {
        return cars.getPositions();
    }
}
