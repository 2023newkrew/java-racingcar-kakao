package racingcar;

import java.util.Random;

public class Engine {

    private static final int POWER_THRESHOLD = 4;

    private static final Engine defaultEngine = new Engine(10);

    private static final Random RANDOM = new Random();

    private final int maxPower;

    public static Engine getDefaultEngine() {
        return defaultEngine;
    }

    private Engine(int maxPower) {
        this.maxPower = maxPower;
    }

    public boolean movable() {
        return RANDOM.nextInt(maxPower) >= POWER_THRESHOLD;
    }
}
