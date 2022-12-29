/**
 * 기타 기능
 */

package racingcar;

import java.util.Random;

public class Utils {
    public static int getRandomNumber() { //0~9 사이 숫자를 반환한다.
        Random random = new Random();
        return random.nextInt(10);
    }
}