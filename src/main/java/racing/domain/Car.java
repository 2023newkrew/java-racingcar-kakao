package racing.domain;

public class Car implements Comparable<Car> {

    private final String name;
    private int position = 1;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void move() {
        this.position += 1;
    }

    public void moveByCondition(Movable movable) {
        if (movable.isMove()) {
            move();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String positionString = "-".repeat(position);
        return String.format("%s : %s", name, positionString);
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.position, other.position);
    }
}
