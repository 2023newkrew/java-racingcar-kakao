package CarRacing.util;

public class StringUtil {
    public static String[] splitString(String string, String regex) {
        return string.split(regex);
    }

    public static int convertStringToInt(String string) {
        return Integer.parseInt(string);
    }
}
