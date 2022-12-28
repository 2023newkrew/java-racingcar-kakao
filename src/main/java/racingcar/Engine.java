package racingcar;

import java.util.Random;

public class Engine {
    public static final Engine defaultEngine = new Engine();

    private static final Random RANDOM = new Random();

    private Engine() {
    }

    public boolean moveOrStop() {
        return RANDOM.nextInt(10) >= 4;
    }
}
