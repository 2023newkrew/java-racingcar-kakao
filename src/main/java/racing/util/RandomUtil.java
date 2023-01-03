package racing.util;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public static Integer getRandomInteger(int upperBound){
        return random.nextInt(upperBound);
    }
}
