package racing.repository;

import racing.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private final List<Car> cars;

    public CarRepository(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarsAll() {
        return cars;
    }

    public List<Car> getCarsByPosition(int pos) {
        return cars.stream()
                .filter(car -> car.isSamePos(pos))
                .collect(Collectors.toList());
    }
}
