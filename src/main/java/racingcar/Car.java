package racingcar;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        position = 0;
    }

    int move(int threshold) {
        if (threshold >= MOVE_THRESHOLD) position++;
        return position;
    }

    int getPosition() {
        return position;
    }

    String getName() {
        return name;
    }
}
