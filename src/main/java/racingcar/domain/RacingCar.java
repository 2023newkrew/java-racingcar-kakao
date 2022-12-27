package racingcar.domain;

public class RacingCar implements Car {
    private final int BOUND = 3;
    private final String name;


    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    public void move(int seed) {
        if (seed > BOUND) {
            distance++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
