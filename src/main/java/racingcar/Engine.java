package racingcar;

import java.util.Random;

public class Engine {
    public static final Engine defaultEngine = new Engine();

    private static final Random RANDOM = new Random();

    private static final int MAX_RANDOM = 10;

    private static final int THRESHOLD = 4;

    private Engine() {
    }

    public boolean moveOrStop() {
        return RANDOM.nextInt(MAX_RANDOM) >= THRESHOLD;
    }
}
