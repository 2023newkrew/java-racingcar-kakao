package racingcar.domain;

import racingcar.dto.CarDto;

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

    public CarDto toDto() {
        return new CarDto(name, position);
    }

}
