package racingcar.util;

import java.util.Random;

public class RandomGenerator {
    private static final int MAXIMUM_BOUND = 10;
    public static int getRandomNumber(){
        return getRandomNumber(MAXIMUM_BOUND);
    }
    public static int getRandomNumber(int maximumBound){
        return new Random().nextInt(maximumBound);
    }
}
