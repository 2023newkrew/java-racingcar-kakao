package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    private static String[] splitByCustomDelimiter(String string) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(string);
        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(Pattern.quote(delimiter));
        }
        return null;
    }

    private static boolean isValidString(String string) {
        return string == null || string.isEmpty();
    }

    public String[] split(String string) {
        if (isValidString(string)) {
            return new String[]{};
        }
        String[] customStrings = splitByCustomDelimiter(string);
        if (customStrings != null) {
            return customStrings;
        }
        return string.split(DEFAULT_DELIMITER);
    }

    public int sumOf(String[] input) {
        int[] numbers = cast(input);
        return Arrays.stream(numbers).sum();
    }

    private int[] cast(String[] input) {
        int[] result = Arrays.stream(input).mapToInt(Integer::parseInt).filter(i -> i >= 0).toArray();
        if (input.length != result.length) {
            throw new RuntimeException();
        }
        return result;
    }

    public int calculate(String string) {
        String[] splitString = split(string);
        return sumOf(splitString);
    }
}
