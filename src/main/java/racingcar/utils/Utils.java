/**
 * 기타 기능
 */
package racingcar.utils;

import java.util.List;
import java.util.Random;
import java.util.Arrays;

public class Utils {
    public static int getRandomNumber() { //0~9 사이 숫자를 반환한다.
        Random random = new Random();
        return random.nextInt(10);
    }

    public static List<String> stringToStringList(String input) { //컴마로 구분된 문자열을 문자열 리스트로 반환한다.
        return Arrays.asList(input.split(","));
    }

    public static int stringToInt(String input) { //문자열을 숫자로 바꿔 반환한다.
        return Integer.parseInt(input);
    }
}