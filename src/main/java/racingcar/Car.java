package racingcar;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 1;
    }

    public int pickNumber() {
        return (int) (Math.random() * 10);
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (pickNumber() >= 4) {
            distance++;
        }
    }

    @Override
    public String toString() {
        return String.format("차 이름: %s, 거리: %d", name, distance);
    }

    public String getName() {
        return name;
    }
}
