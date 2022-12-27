package racingcar;

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

    public void play() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateBetweenZeroAndNine());
        }
        count--;
    }

    public List<CarDto> selectWinners() {
        Car maxPositionCar = calculateMaxPositionCar();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::toDto)
                .collect(Collectors.toList());
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
