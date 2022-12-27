package racing.domain;

public class Car implements Comparable {
    private final double MOVE_LOWER_BOUND = 4.0;
    private int distance;
    private final String name;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public String getName() {
        return name;
    }

    public boolean move(double number) {
        boolean isMoving = isMoving(number);
        if (isMoving) {
            increaseDistance();
        }
        return isMoving;
    }

    private void increaseDistance() {
        distance++;
    }

    private boolean isMoving(double number) {
        return number >= MOVE_LOWER_BOUND;
    }

    private int getDifference(int opponentDistance) {
        return opponentDistance - distance;
    }

    @Override
    public int compareTo(Object o) {
        Car car = (Car) o;
        return car.getDifference(distance);
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }
}
