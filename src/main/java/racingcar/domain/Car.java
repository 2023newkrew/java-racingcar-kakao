package racingcar.domain;

import racingcar.config.GameSetting;

public class Car {

    private String name;
    private int position;

    public Car(String carName) {
        name = carName;
        position = GameSetting.INITIAL_POSITION;
    }

    public void move(Movable movable) {
        if (movable.isMovable()) {
            position += 1;
        }
    }

    public boolean isSamePosition(Car other) {
        return position == other.position;
    }

    public int comparePosition(Car other) {
        return position - other.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
