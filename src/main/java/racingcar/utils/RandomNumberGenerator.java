package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private Random random;

    public RandomNumberGenerator() {
        random = new Random();
    }

    public int generateBetweenZeroAndNine() {
        return random.nextInt(10);
    }
}
