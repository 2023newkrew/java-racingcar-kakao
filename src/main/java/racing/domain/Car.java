package racing.domain;

import java.util.Optional;

public class Car {
    private static final double MOVE_LOWER_BOUND = 4.0;
    private static final String PROGRESS_INNER_STRING = " : ";
    private static final String PROGRESS_SYMBOL = "-";
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean move(double number) {
        boolean isMoving = isMoving(number);
        if (isMoving) {
            increaseDistance();
        }
        return isMoving;
    }

    private void increaseDistance() {
        distance++;
    }

    private boolean isMoving(double number) {
        return number >= MOVE_LOWER_BOUND;
    }

    public boolean equalsDistance(int distance) {
        return this.distance == distance;
    }

    @Override
    public String toString() {
        return name + PROGRESS_INNER_STRING + PROGRESS_SYMBOL.repeat(distance);
    }
}
