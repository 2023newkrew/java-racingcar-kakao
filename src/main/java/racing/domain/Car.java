package racing.domain;

public class Car implements Comparable<Car> {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private String progressChar;
    private int position;

    public Car(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = 0;
        this.progressChar = "-";
    }

    public String getName() {
        return name;
    }

    public void setProgressChar(String progressChar) {
        this.progressChar = progressChar;
    }

    public void move() {
        this.position += 1;
    }

    @Override
    public String toString() {
        String positionString = progressChar.repeat(position + 1);
        return String.format("%s : %s", name, positionString);
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.position, other.position);
    }
}
