package mvc.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (moveVal() >= MOVE_THRESHOLD)
            position++;
    }

    protected int moveVal() {
        return RandomNumGenerator.generateNum();
    }

    public int getPosition() {
        return position;
    }
}
