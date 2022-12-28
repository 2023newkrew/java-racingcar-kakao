package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final int maxTryCount;
    private final Cars cars;
    private int tryCount;

    public RacingGame(int maxTryCount, NumberGenerator numberGenerator, List<String> names) {
        this.cars = createCars(numberGenerator, names);
        this.maxTryCount = maxTryCount;
        this.tryCount = 0;
    }

    private Cars createCars(NumberGenerator numberGenerator, List<String> names) {
        if (names.size() == 0) {
            throw new IllegalArgumentException();
        }

        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(numberGenerator, cars);
    }

    public void move() {
        if(isFinished()){
            throw new IllegalStateException();
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
