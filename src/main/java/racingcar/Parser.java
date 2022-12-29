/**
 * 인풋 문자열을 다른 자료구조로 바꿔주는 역할을 한다
 */
package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Parser {
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