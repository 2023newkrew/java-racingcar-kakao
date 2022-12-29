package racingcar.domain;

public class Car {
    private static final int INITIAL_DISTANCE = 1;
    private static final int MOVE_STANDARD = 4;
    private static final int RANDOM_BOUND = 10;
    private static final String TO_STRING_FORMAT = "차 이름: %s, 거리: %d";

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = INITIAL_DISTANCE;
    }

    public void move() {
        if (pickNumber() >= MOVE_STANDARD) {
            distance++;
        }
    }

    public int pickNumber() {
        return (int) (Math.random() * RANDOM_BOUND);
    }


    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, name, distance);
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
