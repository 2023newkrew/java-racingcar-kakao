package racingcar;

import java.util.Objects;

public class Car implements Comparable{
    private final String name;
    private final RandomGenerator randomGenerator;
    private final Position position;
    private static final int MOVE_BOUND = 4;
    private static final int MAX_BOUND = 9;

    public Car(String name, RandomGenerator rg) {
        this.name = name;
        this.randomGenerator = rg;
        this.position = new Position();
    }

    public boolean move() {
        if (randomGenerator.generate(MAX_BOUND+1) >= MOVE_BOUND) {
            this.position.move();
            return true;
        }
        return false;
    }

    public String toStringOnlyName() {
        return name;
    }
    @Override
    public String toString(){
        return name + " : " + position;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Car)) {
            throw new RuntimeException();
        }
        return this.position.compareTo(((Car) o).position);
    }

    public boolean equalsPosition(Car otherCar) {
        return this.position.equals(otherCar.position);
    }
}
