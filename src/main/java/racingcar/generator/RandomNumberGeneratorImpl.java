package racingcar.generator;

import java.util.Random;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {

    @Override
    public int generator() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
