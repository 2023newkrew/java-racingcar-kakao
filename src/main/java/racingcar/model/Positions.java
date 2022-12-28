package racingcar.model;

import java.util.List;

public class Positions {

    private List<Car> cars;

    public Positions(List<Car> cars) {
        this.cars = cars;
    }

    public int getPositionByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .mapToInt(Car::getPosition)
                .findFirst()
                .orElseThrow();
    }
}