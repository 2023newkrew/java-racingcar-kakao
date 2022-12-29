package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> toList() {
        return cars;
    }

    public void tryForward() {
        cars.forEach(Car::forward);
    }

    private void sortByDistance() {
        sort(cars);
    }

    public List<String> winner() {
        sortByDistance();
        final int maxDist = cars.get(0).getDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDist)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
