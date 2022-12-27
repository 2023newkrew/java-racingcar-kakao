package racingcar;

import java.util.List;

public class Validator {

    public static boolean isValidSingleName(String name) {
        if (name.length() > 5 || name.length() == 0) {
            return false;
        }
        if (name.contains(" ")) {
            return false;
        }
        return true;
    }

    public static boolean isValidNames(List<String> names) {
        if (names.size() != names.stream().distinct().count()) return false;

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
