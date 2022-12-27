package racingcar;

import java.util.Objects;

public class Car {

    private static final int THRESHOLD = 4;

    private int position;

    private final String name;

    public Car(String name) {
        position = 1;
        if (isInvalidName(name)) {
            throw new RuntimeException();
        }
        this.name = name;
    }

    public boolean isInvalidName(String name) {
        return name == null || name.equals("") || name.length() > 5;
    }

    public void move(int random) {
        if (random < THRESHOLD) {
            return;
        }
        position += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
