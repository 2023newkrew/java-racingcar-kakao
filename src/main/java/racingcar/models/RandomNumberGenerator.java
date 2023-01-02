package racingcar.models;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    public int generateNumber() {
        return random.nextInt(10);
    }
}
