package racingcar.domain;

public class RacingCar implements Car{
    private final String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    public void move(int seed) {
        if (seed > 3) {
            distance++;
        }
    }

    @Override
    public String toString() {
        return name + " : "+"-".repeat(distance);
    }
}
