/**
 * 기타 기능
 */
package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static int getRandomNumber() { //0~9 사이 숫자를 반환한다.
        Random random = new Random();
        return random.nextInt(10);
    }

    public static List<String> stringArrayToStringList(String[] input) { //컴마로 구분된 문자열을 문자열 리스트로 반환한다.
        List<String> resultList = new ArrayList<>();
        for (String element : input) {
            resultList.add(element);
        }
        return resultList;
    }

    public static int stringToInt(String input) { //문자열을 숫자로 바꿔 반환한다.
        return Integer.parseInt(input);
    }
}