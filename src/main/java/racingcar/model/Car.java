package racingcar.model;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
