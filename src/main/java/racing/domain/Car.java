package racing.domain;

public class Car implements Comparable<Object> {
    private final int MOVING_LOWER_BOUND = 4;
    private final String MOVING_SYMBOL = "-";
    private final String STATUS_STRING_FORMAT = "%s : %s";
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean move(int number) {
        boolean isMoving = isMoving(number);
        if (isMoving) {
            increaseDistance();
        }
        return isMoving;
    }

    private void increaseDistance() {
        distance++;
    }

    private boolean isMoving(int number) {
        return number >= MOVING_LOWER_BOUND;
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
        return String.format(STATUS_STRING_FORMAT, name, MOVING_SYMBOL.repeat(distance));
    }
}
