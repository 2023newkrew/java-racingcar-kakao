package racing.domain;

import racing.movable.Movable;
import racing.movable.RandomlyMovable;

public class Car {
    private static final Movable DEFAULT_MOVABLE = new RandomlyMovable();
    private static final String NULL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";

    private final CarName name;
    private final Movable movable;
    private final Position position;

    public Car(final CarName name) {
        this(name, DEFAULT_MOVABLE, new Position());
    }

    public Car(final CarName name, final Movable movable) {
        this(name, movable, new Position());
    }

    public Car(final CarName name, final Position position) {
        this(name, DEFAULT_MOVABLE, position);
    }

    public Car(final CarName name, final Movable movable, final Position position) {
        if (name == null || movable == null || position == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_EXCEPTION_MESSAGE);
        }
        this.name = name;
        this.movable = movable;
        this.position = position;
    }

    public void move() {
        if (movable.isMoving()) {
            position.increase();
        }
    }

    public CarName getCarName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
