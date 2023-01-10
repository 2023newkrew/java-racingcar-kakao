package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class FarthestCars {
    private int farthestDistance;
    private Cars cars;

    public FarthestCars(int farthestDistance) {
        this.farthestDistance = farthestDistance;
        this.cars = new Cars();
    }

    public Cars getCars() {
        return this.cars;
    }

    public boolean collectIfFarthest(Car car) {
        if (car.getDistance() == this.farthestDistance) {
            this.cars.add(car);
            return true;
        }
        return false;
    }

    public String toString() {
        List<String> names = new ArrayList<>();
        for (Car car : this.cars.getCars()) {
            names.add(car.getName());
        }
        return String.join(", ", names);
    }
}
