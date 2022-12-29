package racing.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;
    private static final Random random = new Random();
    private RandomNumberGenerator() {
        throw new AssertionError();
    }

    public static int generate() {
        return LOWER_BOUND + random.nextInt(UPPER_BOUND - LOWER_BOUND + 1);
    }
}
