package racingcar;

import java.util.Objects;

public class RacingCar implements Comparable<RacingCar> {

    private final String name;
    private int distance;

    public RacingCar(String name) {
        this(name, 1);
    }

    public RacingCar(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(boolean isMove) {
        if (!isMove) {
            return;
        }
        this.distance++;
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

    @Override
    public String toString() {
        return name + " : " +
                "-".repeat(Math.max(0, distance));
    }

    @Override
    public int compareTo(RacingCar other) {
        return Integer.compare(this.distance, other.distance);
    }
}
