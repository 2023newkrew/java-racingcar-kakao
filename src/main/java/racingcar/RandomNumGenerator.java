package racingcar;

import java.util.Random;

public class RandomNumGenerator {

    private static final Random random = new Random();

    public static int makeRandomNumber(int upperBound) {
        return random.nextInt(upperBound);
    }
}
