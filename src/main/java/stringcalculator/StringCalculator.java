package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    public String[] split(String s) {
        if (s == null || s.isEmpty()) {
            return new String[]{};
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(delimiter);
        }
        return s.split(DEFAULT_DELIMITER);
    }

    public int sumOf(String[] input) {
        int[] numbers = cast(input);
        return Arrays.stream(numbers).sum();
    }

    private int[] cast(String[] input) {
        return Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
    }

    public int calculate(String s) {
        String[] splitString = split(s);
        return sumOf(splitString);
    }
}
