package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class Racing {
    private final List<Car> cars = new ArrayList<>();
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public void addCars(List<String> names) {
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public List<Car> getCarList() {
        return cars;
    }

    public void tryForward() {
        cars.forEach(Car::forward);
        count--;
    }

    public int getCount() {
        return count;
    }

    public boolean isFinished() {
        return count == 0;
    }

    public List<String> winner() {
        sort(cars);
        final int maxDist = cars.get(0).getDistance();

        List<String> result = new ArrayList<>();
        cars.stream()
                .filter(car -> car.getDistance() == maxDist)
                .forEach(car -> result.add(car.getName()));

        return result;
    }
}
