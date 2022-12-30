package racing.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars getSamePosCars(Car other) {
        return new Cars(
                cars.stream()
                        .filter(car -> car.isSamePos(other))
                        .collect(Collectors.toList())
        );
    }

    public Car getMaxPosCar() {
        return cars.stream().max(Car::comparePos).orElseThrow();
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

}
