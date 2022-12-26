package stringcalculator;

import java.util.Arrays;

public class StringCalculator {
    private final String delimiter = ",|:";

    public String[] split(String s) {
        if (s == null || s.isEmpty()) {
            return new String[]{};
        }
        return s.split(delimiter);
    }

    private int[] cast(String[] input) {
        return Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
    }

    public int sumOf(String[] input) {
        int[] numbers = cast(input);
        return Arrays.stream(numbers).sum();
    }
}
