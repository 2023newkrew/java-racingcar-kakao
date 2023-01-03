package util;

public class StringUtil {
    public static boolean isBlank(String value){
        return (value == null || value.isEmpty() || value.isBlank());
    }
}
