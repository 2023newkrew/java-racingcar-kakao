package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class CarListManager {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void add(Car other) {
        if (hasDuplicatedCar(other)) {
            throw new RuntimeException();
        }
        cars.add(other);
    }

    public void moveAll() {
        RandomUtil randomUtil = new RandomUtil();
        for (Car car : cars) {
            car.move(randomUtil.generateRandom());
        }
    }

    public List<Car> selectWinners() {
        List<Car> winners = new ArrayList<>();
        OptionalInt maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max();
        if (maxPosition.isEmpty()) {
            return winners;
        }
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition.getAsInt())
                .forEach(winners::add);
        return winners;
    }

    private boolean hasDuplicatedCar(Car other) {
        return cars.stream()
                .anyMatch(car -> car.equals(other));
    }
}
