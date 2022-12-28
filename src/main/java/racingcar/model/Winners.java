package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> cars;

    public Winners(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getWinnerCars() {
        int farDistancePosition = farDistancePosition();
        return findSamePositionCars(farDistancePosition);
    }

    private int farDistancePosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }

    private List<Car> findSamePositionCars(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }
}
