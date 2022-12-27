package racing.domain;

public class Car {
    private final double MOVE_LOWER_BOUND = 4.0;

    public boolean move(double number) {
        boolean isMoving = isMoving(number);
        if (isMoving) {
            increaseDistance();
        }
        return isMoving;
    }

    private void increaseDistance() {
    }

    private boolean isMoving(double number) {
        return number >= MOVE_LOWER_BOUND;
    }
}
