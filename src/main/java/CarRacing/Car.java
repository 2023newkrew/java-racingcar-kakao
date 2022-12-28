package CarRacing;

import java.util.Random;

public class Car {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final int DEFAULT_POSITION = 1;
    private int position;
    private String name;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.position = position;
        this.name = name;
    }

    public int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }

    public void moveCar(boolean move) {
        if(move) {
            position++;
        }
    }

    public void carEvent() {
        moveCar(isMove(createRandomNumber()));
    }

    public int getPosition() {
        return position;
    }

    public int getMaxPosition(int maxPosition) {
        return Math.max(maxPosition, position);
    }

    public String getWinnerName(int maxPosition) {
        if(maxPosition == position) {
            return name;
        }
        return null;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
