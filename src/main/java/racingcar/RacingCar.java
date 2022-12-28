package racingcar;

import java.util.Objects;

public class RacingCar implements Comparable {

    private final String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 1;
    }

    public String getName() {
        return name;
    }

    public void move(boolean isMove) {
        if (!isMove) {
            return;
        }
        this.distance++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return distance == racingCar.distance && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" : ");
        for (int step = 0; step < distance; step++) {
            stringBuilder.append('-');
        }
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Object other) {
        if (!(other instanceof RacingCar)) {
            throw new IllegalArgumentException();
        }
        return Integer.compare(this.distance, ((RacingCar) other).distance);
    }
}
