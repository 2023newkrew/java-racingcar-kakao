package racing.util;

import java.security.SecureRandom;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new SecureRandom();

    public static Integer generateRandomNumber(int bound) {
        return random.nextInt(bound);
    }
}
