package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return this.cars;
    }

    public void add(Car car) {
        this.cars.add(car);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : this.cars) {
            sb.append(car.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
