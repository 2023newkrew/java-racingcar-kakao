package racingcar;

import java.util.Objects;

/**
 * Racing Game에 참가하는 Car 각각의 정보를 담는 클래스입니다.
 * Car Name의 Validation check를 여기서도 진행합니다(Double Check).
 */
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
        return name == null || "".equals(name) || name.length() > 5;
    }

    public void move(int random) {
        if (random < THRESHOLD) {
            return;
        }
        position++;
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
