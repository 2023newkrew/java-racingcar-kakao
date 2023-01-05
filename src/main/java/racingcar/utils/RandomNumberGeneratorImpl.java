package racingcar.utils;

import racingcar.utils.RandomNumberGenerator;

import java.util.Random;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    private static final Random random = new Random();

    @Override
    public int generate(int bound) {
        return random.nextInt(bound + 1);
    }
}
