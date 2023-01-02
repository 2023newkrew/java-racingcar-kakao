package racingcar.model;

import util.StringUtil;

public class Car {

    public static final int MOVE_THRESHOLD = 4;
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_NAME_LENGTH = 1;

    private final String name;
    private int position;

    public Car(Car car){
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public Car(String name) {
        if(StringUtil.isBlank(name)){
            throw new IllegalArgumentException("자동차는 반드시 이름을 가져야 합니다.");
        }
        if(!isValidNameLength(name)){
            throw new IllegalArgumentException("자동차 이름은 " + MIN_NAME_LENGTH + " 이상 " + MAX_NAME_LENGTH + " 이하여야 합니다.");
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
