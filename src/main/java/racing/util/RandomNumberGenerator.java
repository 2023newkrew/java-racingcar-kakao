package racing.util;

import java.security.SecureRandom;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random random = new SecureRandom();

    public static Integer generateRandomNumber() {
        return random.nextInt(10);
    }
}
