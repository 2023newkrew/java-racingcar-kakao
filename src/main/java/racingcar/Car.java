package racingcar;

public class Car {
    private int position;

    public Car() {
        position = 1;
    }

    public void move() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }
}
