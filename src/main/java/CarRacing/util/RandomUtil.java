package CarRacing.util;

import java.util.Random;

public class RandomUtil {
    private final static Random random = new Random();

    public static int generateRandomNumber(int randomNumberRange) {
        return random.nextInt(randomNumberRange);
    }
}
