package racing;

public class Car {
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

    @Override
    public String toString() {
        String positionString = "-".repeat(position);
        return String.format("%s : %s", name, positionString);
    }
}
