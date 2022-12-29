package racingcar.domain.model;

import java.util.Objects;

public class Car {

    private static final int THRESHOLD = 4;

    private static final int CAR_NAME_LIMIT = 5;

    private int position = 1;

    private final String name;

    public Car(String name) {
        checkCarNameLength(name);
        checkEmptyOrNull(name);
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

    private void checkEmptyOrNull(String name) {
        if (name == null || "".equals(name)) {
            throw new RuntimeException();
        }
    }

    private void checkCarNameLength(String name) {
        if (name.length() > CAR_NAME_LIMIT) {
            throw new RuntimeException();
        }
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
