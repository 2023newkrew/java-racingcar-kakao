package racingcar.step2.util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    public static int generateRandomNumber(int upperBound) {
        return random.nextInt(upperBound);
    }
}
