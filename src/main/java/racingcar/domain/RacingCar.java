package racingcar.domain;

import static racingcar.domain.RacingCarConstant.*;
import static racingcar.domain.RacingCarExceptionMessage.CAR_NAME_BOUND_EXCEPTION_MESSAGE;
import static racingcar.domain.RacingCarExceptionMessage.CAR_NAME_NOT_OR_BLANK_EXCEPTION_MESSAGE;
import static racingcar.domain.RacingCarExceptionMessage.MOVE_INPUT_EXCEPTION_MESSAGE;

import java.util.Objects;

public class RacingCar implements Car {
    private final String name;

    private int distance;

    public RacingCar(String name) {
        isNameValid(name);
        this.name = name;
        this.distance = 0;
    }

    private void isNameValid(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_NOT_OR_BLANK_EXCEPTION_MESSAGE);
        }
        if (name.length() > MAXIMUM_CAR_NAME) {
            throw new IllegalArgumentException(CAR_NAME_BOUND_EXCEPTION_MESSAGE);
        }

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public void move(int condition) {
        if (outOfBound(condition)) {
            throw new IllegalArgumentException(MOVE_INPUT_EXCEPTION_MESSAGE);
        }
        if (condition >= MOVE_LOWER_BOUND) {
            distance++;
        }
    }

    @Override
    public boolean outOfBound(int condition) {
        return condition < CONDITION_LOWER_BOUND || condition > CONDITION_UPPER_BOUND;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(distance));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return distance == racingCar.distance && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }


}
