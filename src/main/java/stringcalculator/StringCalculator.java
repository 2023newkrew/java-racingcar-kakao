package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";

    private static final Pattern NAMES_WITH_CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public String[] split(String names) {
        Matcher m = NAMES_WITH_CUSTOM_DELIMITER_PATTERN.matcher(names);
        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(Pattern.quote(delimiter));
        }
        return names.split(DEFAULT_DELIMITER);
    }

    public int sum(int[] ints) {
        return Arrays.stream(ints).sum();
    }

    public int[] cast(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public boolean hasNegative(int[] ints) {
        return Arrays.stream(ints).anyMatch(i -> i < 0);
    }

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        String[] strings = split(s);
        int[] ints = cast(strings);

        if (hasNegative(ints)) {
            throw new RuntimeException();
        }

        return sum(ints);
    }
}
