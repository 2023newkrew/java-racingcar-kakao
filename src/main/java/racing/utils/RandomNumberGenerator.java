package racing.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private final int UPPER_BOUND = 9;

    public Integer generate() {
        final Random random = new Random();
        return random.nextInt(UPPER_BOUND);
    }
}
