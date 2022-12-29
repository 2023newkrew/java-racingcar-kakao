package racingcar.view;

import java.util.List;

public class Validator {

    private final static int CAR_NAME_MAX_LENGTH = 5;

    // 문자열을 정수로 변환할 수 있는지 여부 반환
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // 시도 횟수 입력값이 유효한지 여부 반환
    public static boolean isValidRoundInput(String str) {
        if (!isInteger(str)) {
            return false;
        }
        if (Integer.parseInt(str) < 0) {
            return false;
        }
        return true;
    }

    // 문자열의 길이가 특정 값을 넘지 않는지 여부 반환
    public static boolean isLengthLessThanLimit(String str) {
        if (str.length() > CAR_NAME_MAX_LENGTH) {
            return false;
        }
        return true;
    }

    // 쉼표로 구분하여 입력한 이름들의 유효성을 반환
    public static boolean isValidNamesInput(String namesInput) {
        if (namesInput.trim().isBlank()) {
            return false;
        }
        boolean flag = true;
        List<String> names = List.of(namesInput.split(","));
        //TODO: 중간에라도 한계 길이 이상의 이름을 만나면 iteration을 끝내는 방식으로 변경 필요
        for (String name : names) {
            flag = isLengthLessThanLimit(name.trim()) && flag;
        }
        return flag;
    }
}
