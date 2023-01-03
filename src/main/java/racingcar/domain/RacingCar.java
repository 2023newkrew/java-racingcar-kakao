package racingcar.domain;

import java.util.Objects;

public class RacingCar implements Comparable<RacingCar> {

    private final RacingCarName racingCarName;
    private int distance;

    public RacingCar(String racingCarName) {
        this(racingCarName, 1);
    }

    public RacingCar(String racingCarName, int distance) {
        this.racingCarName = new RacingCarName(racingCarName);
        this.distance = distance;
    }

    public RacingCarName getRacingCarName() {
        return racingCarName;
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
        return distance == racingCar.distance && Objects.equals(racingCarName, racingCar.racingCarName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarName, distance);
    }

    @Override
    public String toString() {
        return racingCarName.toString() +
                " : " +
                "-".repeat(Math.max(0, distance));
    }

    @Override
    public int compareTo(RacingCar other) {
        return Integer.compare(this.distance, other.distance);
    }
}
