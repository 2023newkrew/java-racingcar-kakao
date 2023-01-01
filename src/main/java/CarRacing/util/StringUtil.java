package CarRacing.util;

import CarRacing.domain.CarName;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringUtil {
    public static String[] splitString(String string, String regex) {
        return string.split(regex);
    }

    public static boolean isBlank(String string) {
        return string == null;
    }
    public static int convertStringToInt(String string) {
        return Integer.parseInt(string);
    }

    public static List<String> convertCarNameListToStringList(List<CarName> carNames) {
        List<String> strings = carNames.stream()
                .map(CarName::toString)
                .collect(Collectors.toList());
        return strings;
    }

    public static String joinStringList(String delimiter, List<String> strings) {
        return String.join(delimiter, strings);
    }
}
