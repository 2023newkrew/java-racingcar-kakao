package racingcar;

import java.util.List;

public class CarList {
    private List<Car> cars;

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
}
