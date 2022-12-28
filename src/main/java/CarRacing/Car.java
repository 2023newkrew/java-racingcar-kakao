package CarRacing;

import java.util.Random;

public class Car {

    private final int MAX_VALUE = 10;
    private final int THRESHOLD = 4;

    private int position;
    private String name;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_VALUE);
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= THRESHOLD;
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
