package mvc.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 함.");
        }
        this.name = name;
        this.position = position;
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
