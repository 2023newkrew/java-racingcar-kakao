package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final NumberGenerator numberGenerator;
    private final List<Car> cars;

    public Cars(NumberGenerator numberGenerator, List<Car> cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    void move() {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public int getPositionByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .mapToInt(Car::getPosition)
                .findFirst()
                .orElseThrow();
    }

    public List<Car> getWinners() {
        int farDistancePosition = getFarDistancePosition();
        return getCarsByPosition(farDistancePosition);
    }

    private int getFarDistancePosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }

    private List<Car> getCarsByPosition(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }
}
