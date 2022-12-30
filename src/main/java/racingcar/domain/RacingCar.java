package racingcar.domain;

import static racingcar.domain.RacingCarConstant.BASIC_DIST;
import static racingcar.domain.RacingCarConstant.CONDITION_LOWER_BOUND;
import static racingcar.domain.RacingCarConstant.CONDITION_UPPER_BOUND;
import static racingcar.domain.RacingCarConstant.MAXIMUM_CAR_NAME;
import static racingcar.domain.RacingCarConstant.MOVE_LOWER_BOUND;
import static racingcar.domain.RacingCarExceptionMessage.CAR_NAME_BOUND_EXCEPTION_MESSAGE;
import static racingcar.domain.RacingCarExceptionMessage.MOVE_INPUT_EXCEPTION_MESSAGE;

import java.util.Objects;

public class RacingCar extends Car {

    private int distance;

    public RacingCar(String name) {
        super(name);
        this.distance = 0;
        isNameValid(name);
    }

    private void isNameValid(String name) {
        if (name.length() > MAXIMUM_CAR_NAME) {
            throw new IllegalArgumentException(CAR_NAME_BOUND_EXCEPTION_MESSAGE);
        }
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
            this.distance += BASIC_DIST;
        }
    }

    @Override
    public boolean outOfBound(int condition) {
        return condition < CONDITION_LOWER_BOUND || condition > CONDITION_UPPER_BOUND;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", super.getName(), "-".repeat(this.distance));
    }


}
