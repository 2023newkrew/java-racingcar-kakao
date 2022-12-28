package racing.domain;

import racing.dto.CarDTO;
import racing.movable.Movable;
import racing.movable.RandomlyMovable;

public class Car {
    private static final String MOVING_SYMBOL = "-";
    private static final String STATUS_STRING_FORMAT = "%s : %s";
    private final String name;
    private final Movable movable;
    private int distance = 0;
    private static final Movable DEFAULT_MOVABLE = new RandomlyMovable();

    public Car(final String name) {
        this(name, DEFAULT_MOVABLE);
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

    private void increaseDistance() {
        distance++;
    }

    @Override
    public String toString() {
        return String.format(STATUS_STRING_FORMAT, name, MOVING_SYMBOL.repeat(distance));
    }

    public CarDTO toDTO() {
        return new CarDTO(name, distance);
    }
}
