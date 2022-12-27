package racing;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        String positionString = "-".repeat(position + 1);
        return String.format("%s : %s", name, positionString);
    }
}
