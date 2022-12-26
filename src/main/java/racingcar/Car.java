package racingcar;

import java.util.List;

public class Car {
    private final String name;
    private int position = 1;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 1);
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
