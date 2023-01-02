package racingcar;

public class Car {
    private final String name;
    private int position;
    private final static int MOVE_THRESHOLD = 4;

    Car(final String name) {
        this(name, 0);
    }

    Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    void move(final int value) { //flag = 1이면 포지션을 증가시키고, 포지션을 반환, 0이면 포지션을 반환
        if (value >= MOVE_THRESHOLD) position++;
    }

    int getPosition() {
        return position;
    }

    String getName() {
        return name;
    }

    String matchPosition(int maxPosition) {
        if (maxPosition == position) {
            return name + ",";
        }
        return "";
    }
}
