package racingcar;

import java.util.Random;

public class RandomUtil {
    /*
     * Random Number를 생성하는 유틸 클래스입니다.
     */

    Random rand;

    public RandomUtil() {
        rand = new Random();
    }

    public int generateRandom() {
        return rand.nextInt(10);
    }
}
