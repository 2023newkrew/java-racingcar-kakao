package CarRacing.domain;

import CarRacing.util.RandomUtil;

public class Car {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final int DEFAULT_POSITION = 1;
    private static final int CAR_SPEED = 1;
    private final String name;
    private int position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.position = position;
        this.name = name;
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }

    public void moveCar(boolean move) {
        if (move) {
            position += CAR_SPEED;
        }
    }

    public void carEvent() {
        moveCar(isMove(RandomUtil.generateRandomNumber(RANDOM_NUMBER_RANGE)));
    }

    public int getMaxPosition(int maxPosition) {
        return Math.max(maxPosition, position);
    }

    public String getWinnerName(int maxPosition) {
        if (maxPosition == position) {
            return name;
        }
        return null;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
