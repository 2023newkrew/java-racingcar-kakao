package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private List<Car> cars;
    private int count;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingCarGame(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.count = gameCount;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public GameResult play() {
        List<CarDto> intermediateResult = new ArrayList<>();

        for (Car car : cars) {
            car.move(randomNumberGenerator.generateBetweenZeroAndNine());
            intermediateResult.add(car.toDto());
        }
        count--;

        return new GameResult(intermediateResult);
    }

    public GameResult selectWinners() {
        Car maxPositionCar = calculateMaxPositionCar();
        List<CarDto> finalResult = cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::toDto)
                .collect(Collectors.toList());

        return new GameResult(finalResult);
    }

    public Car calculateMaxPositionCar() {
        return cars.stream()
                .max(Car::comparePosition)
                .orElseThrow();
    }

    public boolean isFinish() {
        return count == 0;
    }
}
