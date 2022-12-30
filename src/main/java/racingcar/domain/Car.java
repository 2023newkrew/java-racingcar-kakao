package racingcar.domain;

import static racingcar.domain.RacingCarExceptionMessage.CAR_NAME_NOT_OR_BLANK_EXCEPTION_MESSAGE;

import java.util.Objects;
import stringutils.StringUtils;

public abstract class Car {

    private final String name;

    protected Car(String name) {
        StringUtils.checkNullOrBlank(name, CAR_NAME_NOT_OR_BLANK_EXCEPTION_MESSAGE);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract int getDistance();

    public abstract void move(int condition);

    public abstract boolean outOfBound(int condition);

    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
