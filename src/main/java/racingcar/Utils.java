/**
 * 구현할 기능
 * 1. 자동차 이름 파싱 & 검증
 * 2. 라운드 횟수 검증
 * 3. 랜덤 난수 생성(0~9) ??
 */

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<String> separateStringToList(String input) { //컴마로 구분된 문자열을 문자열 리스트로 반환한다.
        String[] separatedArray = input.split(",");
        List<String> resultList = new ArrayList<>();
        for (String element : separatedArray) {
            resultList.add(element);
        }
        return resultList;
    }

    public static int stringToInt(String input) { //문자열을 숫자로 바꾼다.
        return Integer.parseInt(input);
    }
}