package racingcar;

public class Validator {

    public static boolean validateName(String name) {
        if (name.length() > 5 || name.length() == 0) {
            return false;
        }
        if (name.contains(" ")) {
            return false;
        }
        return true;
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
