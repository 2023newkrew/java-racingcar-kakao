package stringcalc;

import java.util.ArrayList;
import java.util.List;

public class StringNumberParser {

    public static final String DEFAULT_SEPARATOR = "[,:]";

    public List<Long> parse(String input, String separator) {
        if (input == null || input.isBlank()) {
            return new ArrayList<>();
        }
        if (separator == null) {
            String[] stringNumbers = input.split(DEFAULT_SEPARATOR);
            return convertToNumbers(stringNumbers);
        }
        return separateWithCustomSeparator(input, separator);
    }

    private List<Long> separateWithCustomSeparator(String input, String separator) {
        String sequentialNumberString = input.substring("//.\n".length());
        String[] stringNumbers = sequentialNumberString.split(separator);
        return convertToNumbers(stringNumbers);
    }

    private List<Long> convertToNumbers(String[] stringNumbers) {
        List<Long> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            numbers.add(convertToNumber(stringNumber));
        }
        if (numbers.stream().anyMatch(num -> num < 0)) {
            throw new RuntimeException("잘못된 입력: 음수");
        }
        return numbers;
    }

    private Long convertToNumber(String stringNumber) {
        try {
            return Long.parseLong(stringNumber);
        }catch (NumberFormatException ex) {
            throw new RuntimeException(ex);
        }
    }
}
