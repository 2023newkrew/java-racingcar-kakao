package racingcar;

import java.util.Objects;

public class Car {

    private static final int THRESHOLD = 4;

    private static final int CAR_NAME_LIMIT = 5;

    private int position;

    private final String name;

    public Car(String name) {
        if (isInvalidName(name)) {
            throw new RuntimeException();
        }
        position = 1;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int random) {
        if (random < THRESHOLD) {
            return;
        }
        position += 1;
    }

    private boolean isInvalidName(String name) {
        return name == null || name.equals("") || name.length() > CAR_NAME_LIMIT;
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
