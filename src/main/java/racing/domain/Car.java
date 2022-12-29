package racing.domain;

public class Car {
    private static final double MOVE_LOWER_BOUND = 4.0;
    private static final String PROGRESS_INNER_STRING = " : ";
    private static final String PROGRESS_SYMBOL = "-";
    private static final String NAME_MINIMUM_LENGTH_MESSAGE = "자동차 이름은 1자 이상이어야 합니다.";
    private static final String NAME_MAX_LENGTH_MESSAGE = "자동차 이름은 5자 이하여야 합니다.";
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
        distance = 0;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NAME_MINIMUM_LENGTH_MESSAGE);
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_MAX_LENGTH_MESSAGE);
        }
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
