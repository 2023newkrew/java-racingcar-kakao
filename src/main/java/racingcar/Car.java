package racingcar;

import java.util.Objects;

public class Car {
    private final String name;
    private final Position position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int defaultPosition) {
        this.name = name;
        this.position = new Position(defaultPosition);
    }

    public boolean move(Movable movable) {
        if (movable.canMove()) {
            this.position.move();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
    public String toStringWithPosition(){
        return name + " : " + position;
    }

    public int comparePosition(Car other) {
        return this.position.compareTo(other.position);
    }

    public boolean equalsPosition(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
