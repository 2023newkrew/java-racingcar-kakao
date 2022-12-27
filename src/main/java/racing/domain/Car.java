package racing.domain;

public class Car implements Comparable{
    private final double MOVE_LOWER_BOUND = 4.0;
    private int distance;
    public final String name;

    public Car(String name) {
        this.name = name;
        distance = 0;
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

    public int getDifference(int opponentDistance) {
        return opponentDistance - distance;
    }

    @Override
    public int compareTo(Object o) {
        Car car = (Car) o;
        return car.getDifference(distance);
    }
}
