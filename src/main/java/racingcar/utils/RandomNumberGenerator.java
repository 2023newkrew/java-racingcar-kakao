package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int BOUND = 10;
    private Random random;

    public RandomNumberGenerator() {
        random = new Random();
    }

    public int generateBetweenZeroAndNine() {
        return random.nextInt(BOUND);
    }
}
