package racing.domain;

public class Car {
    private final double MOVE_LOWER_BOUND = 4.0;
    private int distance;
    private final String name;

    public Car(String name) {
        this.name = name;
        distance = 0;
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
}
