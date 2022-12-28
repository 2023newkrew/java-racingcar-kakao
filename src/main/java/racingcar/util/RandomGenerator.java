package racingcar.util;

import java.util.Random;

public class RandomGenerator {

    private final static Random random = new Random();

    public static int generateOneDigit() {
        return random.nextInt(10);
    }
}
