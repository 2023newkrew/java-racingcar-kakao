package racingcar;

import java.util.Objects;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        position = 1;
        if (name.length() > 5) {
            throw new RuntimeException();
        }
        this.name = name;
    }

    public void move() {
        position += 1;
    }

    public int getPosition() {
        return position;
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
