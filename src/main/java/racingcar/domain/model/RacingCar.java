package racingcar.domain.model;

import java.util.Objects;

public abstract class RacingCar {

    protected int position = 1;

    protected final String name;

    public RacingCar(String name) {
        checkEmptyOrNull(name);
        this.name = name;
    }

    public abstract void move();

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    private void checkEmptyOrNull(String name) {
        if (name == null || "".equals(name)) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar that = (RacingCar) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
