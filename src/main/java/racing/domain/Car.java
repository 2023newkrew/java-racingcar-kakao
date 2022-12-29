package racing.domain;

import java.util.Objects;
import racing.dto.CarDTO;
import racing.movable.Movable;
import racing.movable.RandomlyMovable;

public class Car {
    private static final int DEFAULT_DISTANCE = 0;
    private static final Movable DEFAULT_MOVABLE = new RandomlyMovable();
    private static final String NULL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";

    private final CarName name;
    private final Movable movable;
    private int distance = DEFAULT_DISTANCE; //이정도까지 wrapping하는건 과한가 싶습니다ㅎㅎ

    public Car(final CarName name) {
        this(name, DEFAULT_MOVABLE);
    }

    public Car(final CarName name, final Movable movable) {
        if (name == null || Objects.isNull(movable)) {
            throw new IllegalArgumentException(NULL_ARGUMENT_EXCEPTION_MESSAGE);
        }
        this.name = name;
        this.movable = movable;
    }

    public void move() {
        if (movable.isMoving()) {
            increaseDistance();
        }
    }

    public CarDTO toDTO() {
        return new CarDTO(name, distance);
    }

    private void increaseDistance() {
        distance++;
    }
}
