/**
 * 구현할 기능 (완전 다른기능이랑 노상관임)
 * 1. 자동차 이름 파싱 & 검증
 * 2. 라운드 횟수 검증
 * 3. 랜덤 난수 생성(0~9) ??
 */

package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static List<String> stringToStringList(String input) { //컴마로 구분된 문자열을 문자열 리스트로 반환한다.
        String[] separatedArray = input.split(",");
        List<String> resultList = new ArrayList<>();
        for (String element : separatedArray) {
            resultList.add(element);
        }
        //리스트의 각 원소의 크기가 5이상 or 빈문자열이거나 null이면 에러발생시키고 메시지를 출력하자
        return resultList;
    }

    public static int stringToInt(String input) { //문자열을 숫자로 바꿔 반환한다.
        //숫자 형식이 아니거나, 1 미만이면 에러 발생시키고 메시지를 출력하자
        return Integer.parseInt(input);
    }

    public static int getRandomNumber() { //0~9 사이 숫자를 반환한다.
        Random random = new Random();
        return random.nextInt(10);
    }
}