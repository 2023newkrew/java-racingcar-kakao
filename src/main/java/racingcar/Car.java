package racingcar;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int moveCar(int random) {
        if (random >= MOVE_THRESHOLD) {
            position += 1;
        }

        return position;
    }
}
