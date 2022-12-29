package racing.domain;

public class Car implements Comparable {
    private static final double MOVE_LOWER_BOUND = 4.0;
    private static final String PROGRESS_INNER_STRING = " : ";
    private static final String PROGRESS_SYMBOL = "-";
    private final String name;
    private int distance;

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
        return name + PROGRESS_INNER_STRING + PROGRESS_SYMBOL.repeat(distance);
    }
}
