package racingcar.generator;

import java.util.Random;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {

    private static final int RANGE = 9;

    @Override
    public int generator() {
        Random random = new Random();
        return random.nextInt(RANGE + 1);
    }
}
