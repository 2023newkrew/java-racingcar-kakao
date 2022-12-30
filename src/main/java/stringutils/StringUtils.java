package stringutils;

public class StringUtils {

    private StringUtils() {
    }

    public static void checkNullOrBlank(String text, String exceptionMessage) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
    public static boolean checkNullOrBlankReturnBoolean(String text) {
        if (text == null || text.isBlank()) {
            return true;
        }
        return false;
    }

}
