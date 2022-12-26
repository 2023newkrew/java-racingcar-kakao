package racingcar;

import java.util.Random;

public class RandomNumberGenerator {

    private final Random random = new Random();

    public int generateRandomNumber() {
        return random.nextInt(10);
    }
}
