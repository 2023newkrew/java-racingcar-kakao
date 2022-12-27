package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class CarList {
    private final List<Car> cars;

    public CarList() {
        cars = new ArrayList<>();
    }

    public void add(Car other) {
        if (hasDuplicatedName(other)) {
            throw new RuntimeException();
        }
        cars.add(other);
    }

    private boolean hasDuplicatedName(Car other) {
        return cars.stream()
                .anyMatch(car -> car.equals(other));
    }

    public void moveAll() {
        RandomUtil randomUtil = new RandomUtil();
        cars.forEach(car -> car.move(randomUtil.generateRandom()));
    }
}
