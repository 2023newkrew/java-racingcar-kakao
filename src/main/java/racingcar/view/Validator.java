package racingcar.view;

import java.util.List;

public class Validator {
    private static final String NOTICE_INVALID_INPUT = "잘못된 입력값입니다.";;

    private static final int CAR_NAME_MAX_LENGTH = 5;

    public static boolean isValidCarNames(List<String> names) {
        if (names.isEmpty()) {
            return false;
        }
        if (!names.stream().allMatch(Validator::isValidCarName)) {
            System.err.println(NOTICE_INVALID_INPUT);
            return false;
        }
        return true;
    }

    private static boolean isValidCarName(String name) {
        return name.length() <= CAR_NAME_MAX_LENGTH;
    }

    public static boolean isValidGameRoundCnt(String roundInput) {
        if (!isInteger(roundInput)) {
            return false;
        }
        if (Integer.parseInt(roundInput)<0) {
            System.err.println(NOTICE_INVALID_INPUT);
            return false;
        }
        return true;
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.err.println(NOTICE_INVALID_INPUT);
            return false;
        }
        return true;
    }
}
