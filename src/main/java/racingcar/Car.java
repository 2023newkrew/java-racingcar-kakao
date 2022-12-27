package racingcar;

public class Car {
    private int position;

    public void move(int no) {
        if (no > 3)
            position++;
    }

    public int getPosition() {
        return position;
    }
}
