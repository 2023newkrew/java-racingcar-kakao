package racing.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private final int LOWER_BOUND = 0;
    private final int UPPER_BOUND = 9;
    private final Random random = new Random();
    public int generate() {
        return LOWER_BOUND + random.nextInt(UPPER_BOUND - LOWER_BOUND + 1);
    }
}
