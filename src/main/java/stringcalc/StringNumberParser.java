package stringcalc;

import java.util.ArrayList;
import java.util.List;

public class StringNumberParser {
    public static List<Long> parseToNumberList(String input, String separator) {
        if (input.isBlank()) {
            return new ArrayList<>();
        }
        if (separator == null) {
            String[] stringNumbers = input.split("[,:]");
            return convertToNumberList(stringNumbers);
        }
        return separateWithCustomSeparator(input, separator);
    }

    private static List<Long> separateWithCustomSeparator(String input, String separator) {
        String sequentialNumberString = input.substring("//.\n".length());
        String[] stringNumbers = sequentialNumberString.split(separator);
        return convertToNumberList(stringNumbers);
    }

    private static List<Long> convertToNumberList(String[] stringNumbers) {
        List<Long> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            numbers.add(Long.parseLong(stringNumber));
        }
        if (numbers.stream().anyMatch(num -> num < 0)) {
            throw new RuntimeException();
        }
        return numbers;
    }
}
