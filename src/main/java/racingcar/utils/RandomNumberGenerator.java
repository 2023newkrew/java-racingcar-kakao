package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private final Random random;

    private final int bound;

    public RandomNumberGenerator(int bound) {
        this.random = new Random();
        this.bound = bound;
    }

    public int generate() {
        return random.nextInt(bound);
    }
}