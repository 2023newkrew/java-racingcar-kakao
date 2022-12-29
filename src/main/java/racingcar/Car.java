package racingcar;

public class Car {
    private final String name;
    private static final int CONTROL_POINT = 4;
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

    public void moveCar() {
        determineToMove(makeRandomNumber());
    }

    private void determineToMove(int random) {
        if (random >= CONTROL_POINT)
            position += 1;
    }

    private int makeRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
