package racingcar;

public class Car {
    private final String name;
    private int position;

    private static final int INITIAL_POSITION = 1;

    public Car(String name, int position) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new RuntimeException("잘못된 자동차 이름입니다.");
        }
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public String getName() {
        return name;
    }


    public int getPosition() {
        return position;
    }

    public void moveWithPower(int power) {
        if (power >= 4) {
            this.position++;
        }
    }

    public String getCurrentStatus() {
        return this.name + " : "
                + "-".repeat(this.position);
    }
}
