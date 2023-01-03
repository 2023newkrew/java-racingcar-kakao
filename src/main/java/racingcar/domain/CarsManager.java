package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarsManager {

    private final List<Car> cars;

    public CarsManager(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public List<String> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter((car) -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveAll(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<String> getCurrentStatus() {
        return cars.stream().map(Car::getCurrentStatus).collect(Collectors.toList());
    }
}
