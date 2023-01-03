package mvc.domain;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 함.");
        }
        this.name = name;
        this.position = position;
    }

    public void move() {
        if (moveVal() >= 4)
            position++;
    }

    protected int moveVal() {
        return RandomNumGenerator.generateNum();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
