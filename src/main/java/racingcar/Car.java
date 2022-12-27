package racingcar;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        position = 1;
        if (name.length() > 5) {
            throw new RuntimeException();
        }
        this.name = name;
    }

    public void move() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }
}
