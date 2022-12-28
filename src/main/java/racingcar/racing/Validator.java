package racingcar.racing;

import java.util.List;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    public static boolean isValidSingleName(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            return false;
        }
        return !name.isBlank();
    }

    public static boolean isValidNames(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            return false;
        }

        return names.stream().allMatch(Validator::isValidSingleName);
    }

    public static boolean isValidTurn(String turn) {
        int parsedTurn;

        try {
            parsedTurn = Integer.parseInt(turn);
        } catch (NumberFormatException e) {
            return false;
        }

        return parsedTurn > 0;
    }
}
