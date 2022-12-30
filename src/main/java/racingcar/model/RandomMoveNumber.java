package racingcar.model;

import java.util.Random;

public class RandomMoveNumber {
    public static int RANDOM_MAX_LIMIT = 10;
    private static Random random = new Random();

    public static int getRandomMoveNumber() {
        return random.nextInt(RANDOM_MAX_LIMIT);
    }
}