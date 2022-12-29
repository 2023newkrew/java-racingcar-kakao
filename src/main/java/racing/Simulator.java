package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Simulator {
    List<Car> cars = new ArrayList<>();

    public void create(String names) {
        for (String name : names.split(",")) {
            cars.add(new Car(name));
        }
    }

    public void run(Random random) {
        for (Car car : cars) {
            car.moveByCondition(random.nextInt(9));
        }
    }

    public String getWinners() {
        Car maxCar = Collections.max(cars);
        return cars.stream()
                .filter(c -> c.compareTo(maxCar) == 0)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
