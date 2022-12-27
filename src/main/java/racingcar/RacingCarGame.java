package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private List<Car> cars;
    private int count;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingCarGame(List<CarDto> carDtos, int gameCount) {
        this.cars = RacingCarConverter.toCars(carDtos);
        this.count = gameCount;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public GameResult play() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateBetweenZeroAndNine());
        }
        count--;

        List<CarDto> intermediateResult = RacingCarConverter.toCarDtos(cars);
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
