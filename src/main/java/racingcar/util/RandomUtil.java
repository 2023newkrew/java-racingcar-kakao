package racingcar.util;

import java.util.Random;

public final class RandomUtil {
    /**
     * Random Number를 생성하는 유틸 클래스입니다.
     */


    static Random random = new Random();

    private RandomUtil() {

    }

    public static int generateRandom() {
        return random.nextInt(10);
    }
}
