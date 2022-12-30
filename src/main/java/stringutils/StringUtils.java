package stringutils;

import java.util.Objects;

public class StringUtils {

    private StringUtils() {
    }

    public static void checkNullOrBlank(String text, String exceptionMessage) {
        if (isNullOrBlank(text)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }


    public static boolean checkNullOrBlankReturnBoolean(String text) {
        if (isNullOrBlank(text)) {
            return true;
        }
        return false;
    }

    private static boolean isNullOrBlank(String text) {
        return Objects.isNull(text) || text.isBlank();
    }

}
