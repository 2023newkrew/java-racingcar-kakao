package racing.domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    public Car(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = 1;
    }

    public String getName() {
        return name;
    }

    public void move() {
        this.position += 1;
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
