package racingcar.util;

public class Validator {

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
