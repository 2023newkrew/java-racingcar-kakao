package racing_car.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Car implements Comparable<Car> {

    private final String name;

    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public static Car[] from(String[] names) {
        return Arrays.stream(names)
                .map(Car::new)
                .collect(Collectors.toList())
                .toArray(Car[]::new);
    }

    public String getName() {
        return name;
    }

    public String showDistance() {
        return "-".repeat(this.distance);
    }

    public void move(int i) {
        this.distance += i;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.distance, o.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }
}
