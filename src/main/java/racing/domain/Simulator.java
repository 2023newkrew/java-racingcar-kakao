package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Simulator {
    private static final int MOVE_THRESHOLD = 3;
    private static final int RANDOM_MAX_RANGE = 10;
    private final List<Car> cars = new ArrayList<>();
    private final List<String> progress = new ArrayList<>();

    public void create(String names) {
        for (String name : names.split(",")) {
            cars.add(new Car(name));
        }
    }

    private void move(Car car, int random) {
        if (random > MOVE_THRESHOLD) {
            car.move();
        }
    }

    private void run(Random random) {
        for (Car car : cars) {
            move(car, random.nextInt(RANDOM_MAX_RANGE));
        }
    }

    public void simulate(Random random, int times) {
        progress.add(this.toString());
        for (int i = 0; i < times; i++) {
            run(random);
            progress.add(this.toString() + "\n");
        }
    }

    public String getProgress() {
        return String.join("\n", progress);
    }

    public String winners() {
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
