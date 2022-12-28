package racingcar.domain;

import static racingcar.domain.RacingCarConstant.*;

import java.util.Objects;

public class RacingCar implements Car {
    private final String name;

    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    public void move(int condition) {
        if (outOfBound(condition)) {
            throw new IllegalArgumentException("move함수에는 0 ~ 9 사이의 값이 주어져야 합니다.");
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
