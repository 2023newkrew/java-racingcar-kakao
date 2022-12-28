package racingcar;

public class Car {
    private final String name;
    private final RandomGenerator randomGenerator;
    private int position;
    private static final int MOVE_BOUND = 4;
    private static final int MAX_BOUND = 9;

    public Car(String name, RandomGenerator rg) {
        this.name = name;
        this.randomGenerator = rg;
        this.position = 0;
    }

    public boolean move() {
        if (movable()) {
            this.position++;
            return true;
        }
        return false;
    }

    public boolean movable() {
        return randomGenerator.generate(MAX_BOUND) >= MOVE_BOUND;
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
}
