package racingcar.domain;

import racingcar.config.GameSetting;
import racingcar.service.dto.CarResponse;

public class Car {

    private String name;
    private int position;

    public Car(String carName) {
        name = carName;
        position = GameSetting.INITIAL_POSITION;
    }

    public void move(int randomNumber) {
        if (isMovable(randomNumber)) {
            position += 1;
        }
    }

    public boolean isMovable(int randomNumber) {
        return randomNumber >= GameSetting.MOVABLE_MIN_VALUE;
    }

    public boolean isSamePosition(Car other) {
        return position == other.position;
    }

    public int comparePosition(Car other) {
        return position - other.position;
    }

    public CarResponse toResponse() {
        return new CarResponse(name, position);
    }

}
