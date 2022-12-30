package racingcar;

import java.util.Objects;
import java.util.Random;

public class Engine {
    private static final Random RANDOM = new Random();
    private static final int MAX_POWER = 10;
    private static Engine defaultEngine;

    public static Engine getDefaultEngine() {
        if (Objects.isNull(defaultEngine)) {
            synchronized (Engine.class) {
                defaultEngine = new Engine();
            }
        }
        return defaultEngine;
    }

    private Engine() {
    }

    public int getPower() {
        return RANDOM.nextInt(MAX_POWER);
    }
}
