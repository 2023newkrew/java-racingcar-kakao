package racingcar.model;

public class Car {
    public final static int POWER_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void accelerate(int power) {
        if (power >= this.POWER_THRESHOLD) {
            this.position += 1;
        }
    }
}
