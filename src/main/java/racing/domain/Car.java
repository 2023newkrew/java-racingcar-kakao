package racing.domain;

import racing.dto.CarDTO;
import racing.movable.Movable;
import racing.movable.RandomlyMovable;

public class Car {
    private final CarName name;
    private final Movable movable;
    private int distance = 0;
    private static final Movable DEFAULT_MOVABLE = new RandomlyMovable();

    public Car(final CarName name) {
        this(name, DEFAULT_MOVABLE);
    }

    public Car(final CarName name, final Movable movable){
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

    public CarDTO toDTO() {
        return new CarDTO(name, distance);
    }
}
