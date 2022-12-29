package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable{
    private final String name;
    private final RandomGenerator randomGenerator;
    private final Position position;
    private static final int MOVE_BOUND = 4;
    private static final int MAX_BOUND = 9;

    public Car(String name, RandomGenerator rg) {
        if (name.length() < 0 || name.length()>5){
            throw new InvalidInputException("1 : Name should be between 1 and 5.");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Car car = (Car) o;
        return name.equals(car.name) && position.equals(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public boolean equalsPosition(Car otherCar) {
        return this.position.equals(otherCar.position);
    }
}
