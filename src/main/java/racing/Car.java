package racing;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 1;

    public Car(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void move() {
        this.position += 1;
    }

    public void move(int value) {
        if (value > 3) {
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
