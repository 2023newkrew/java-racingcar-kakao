package stringcalculator.utils;

import static stringcalculator.config.ErrorMessage.INPUT_ERROR_MESSAGE;

public class StringUtils {

    public static int convertToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

}
