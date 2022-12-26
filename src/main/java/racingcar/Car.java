package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void playTurn() {
        determineToMove(makeRandomNumber());
    }

    public void determineToMove(int random) {
        if (random >= 4)
            position += 1;
    }

    public int makeRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
