package racingcar.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    private RandomUtil() {
    }

    public static int generateRandomNumber(int bound) {
        return random.nextInt(bound);
    }
}
