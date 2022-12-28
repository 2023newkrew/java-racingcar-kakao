package racingcar;

public class Car {
    private final String name;
    private int position;
    private static final int MOVE_BOUND = 4;
    private static final int MAX_BOUND = 9;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(RandomGenerator rg) {
        if (movable(rg)) {
            this.position++;
        }
    }

    private boolean movable(RandomGenerator rg) {
        return rg.generate(MAX_BOUND) >= MOVE_BOUND;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toStringWithPosition(){
        return name + " : " + "-".repeat(position+1);
    }

    public int comparePositionToOtherCar(Car otherCar) {
        return otherCar.comparePositionTo(position);
    }

    private int comparePositionTo(int otherPosition) {
        return otherPosition - this.position;
    }

    public boolean equalsPositionToOtherCar(Car otherCar) {
        return otherCar.equalsPositionTo(position);
    }

    private boolean equalsPositionTo(int otherPosition) {
        return this.position == otherPosition;
    }

    public Car determineWinner(Car otherCar) {
        if(comparePositionToOtherCar(otherCar) >= 0) {
            return this;
        }
        return otherCar;
    }
}
