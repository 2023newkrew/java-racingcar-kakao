package racingcar;

import java.util.Random;

public class RandomUtil {

    Random rand;

    public RandomUtil() {
        rand = new Random();
    }

    public int generateRandom() {
        return rand.nextInt(10);
    }
}
