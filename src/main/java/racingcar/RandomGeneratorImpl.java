package racingcar;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator{
    private static final Random random = new Random();

    @Override
    public int generate(int bound) {
        return this.random.nextInt(bound+1);
    }
}
