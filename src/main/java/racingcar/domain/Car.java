package racingcar.domain;

public class Car {
    private String name;
    private int distance;

    private static final int INITIAL_DISTANCE = 1;
    private static final int MOVE_STANDARD = 4;
    private static final String TO_STRING_FORMAT = "차 이름: %s, 거리: %d";

    public Car(String name) {
        this.name = name;
        this.distance = INITIAL_DISTANCE;
    }

    public void move(int number) {
        if (number >= MOVE_STANDARD) {
            distance++;
        }
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
