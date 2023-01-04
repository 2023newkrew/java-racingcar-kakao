package racingcar.domain;

import racingcar.dto.CarInfo;

public class Car {
    private final String name;
    private int position = 1;

    public Car(final String name) {
        this.name = name;
    }

    public void move(final MovableStrategy movableStrategy) {
        if (movableStrategy.isMovable()) {
            position += 1;
        }
    }

    public boolean isSamePosition(Car other) {
        return position == other.position;
    }

    public int comparePosition(Car other) {
        return position - other.position;
    }

    public CarInfo toDto() {
        return new CarInfo(name, position);
    }

}