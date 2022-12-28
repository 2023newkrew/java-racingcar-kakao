package racingcar;

import java.util.Random;

public class Engine {
    public static final Engine defaultEngine = new Engine(10);

    private static final Random RANDOM = new Random();

    private final int maxPower;

    private Engine(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getPower() {
        return RANDOM.nextInt(maxPower);
    }
}
