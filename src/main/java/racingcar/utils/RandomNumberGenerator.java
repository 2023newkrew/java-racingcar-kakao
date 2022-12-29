package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private final Random random;

    public RandomNumberGenerator() {
        random = new Random();
    }

    public int generateBetweenZeroAndNine() {
        return random.nextInt(10);
    }
}