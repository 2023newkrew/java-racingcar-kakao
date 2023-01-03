package racingcar.model;

import util.StringUtil;

import static racingcar.model.CarConstant.*;

public class Car {
    private final String name;
    private int position;

    public Car(Car car){
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public Car(String name) {
        if(StringUtil.isBlank(name)){
            throw new IllegalArgumentException(CAR_NAME_REQUIRED_EXCEPTION_MSG);
        }
        if(!isValidNameLength(name)){
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_EXCEPTION_MSG);
        }

        this.name = name;
        this.position = 0;
    }

    public void move(int moveValue) {
        if (isMovable(moveValue)) {
            position++;
        }
    }

    private boolean isValidNameLength(String name) {
        return (MIN_NAME_LENGTH <= name.length() && name.length() <= MAX_NAME_LENGTH);
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
