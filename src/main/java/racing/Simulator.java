package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Simulator {
    List<Car> cars = new ArrayList<>();

    public void create(String names) {
        for (String name : names.split(",")) {
            cars.add(new Car(name));
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
