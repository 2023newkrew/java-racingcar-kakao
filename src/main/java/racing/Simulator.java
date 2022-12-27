package racing;

import java.util.ArrayList;
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
            car.move(random.nextInt(9));
        }
    }

    public void simulate(Random random, int times) {
        for (int i = 0; i < times; i++) {
            run(random);
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
