package racingcar;

public class Car {
    private final String name;
    private int position = 1;

    public Car(String name) {
        this.name = name;
    }

    public void moveWithPower(int power) {
        if (power > 3) {
            this.position++;
        }
    }

    public String getCurrentStatus() {
        return this.name + " : "
                + "-".repeat(Math.max(0, this.position));
    }
}
