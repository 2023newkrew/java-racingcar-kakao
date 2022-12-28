package racing.domain;

import racing.dto.CarDTO;
import racing.movable.Movable;
import racing.movable.RandomlyMovable;

public class Car {
    private static final int MOVING_LOWER_BOUND = 4;
    private static final String MOVING_SYMBOL = "-";
    private static final String STATUS_STRING_FORMAT = "%s : %s";
    private final String name;
    private final Movable movable;
    private int distance = 0;

    public Car(final String name) {
        this(name, new RandomlyMovable());
    }

    public Car(final String name, final Movable movable){
        this.name = name;
        this.movable = movable;
    }

    public void move() {
        if (movable.isMoving()) {
            increaseDistance();
        }
    }

    public boolean move(final int number) {
        boolean isMoving = isMoving(number);
        if (isMoving) {
            increaseDistance();
        }
        return isMoving;
    }

    private void increaseDistance() {
        distance++;
    }

    private boolean isMoving(int number) {
        return number >= MOVING_LOWER_BOUND;
    }

    @Override
    public String toString() {
        return String.format(STATUS_STRING_FORMAT, name, MOVING_SYMBOL.repeat(distance));
    }

    public CarDTO toDTO() {
        return new CarDTO(name, distance);
    }
}
