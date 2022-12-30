package racingcar.util;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {
    private static final Random random = new Random();
    private static RandomGeneratorImpl instance;

    private RandomGeneratorImpl() {}

    public static RandomGeneratorImpl getInstance() {
        if (instance == null) {
            instance = new RandomGeneratorImpl();
        }
        return instance;
    }

    @Override
    public int generate(int bound) {
        return random.nextInt(bound + 1);
    }
}
