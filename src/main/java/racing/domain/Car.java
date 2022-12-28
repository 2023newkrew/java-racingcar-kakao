package racing.domain;

import racing.dto.CarDTO;

public class Car implements Comparable<Object> {
    private static final int MOVING_LOWER_BOUND = 4;
    private static final String MOVING_SYMBOL = "-";
    private static final String STATUS_STRING_FORMAT = "%s : %s";
    private final String name;
    private int distance = 0;

    public Car(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean move(final int number) {
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

    public CarDTO toDTO() {
        return new CarDTO(name, distance);
    }
}
