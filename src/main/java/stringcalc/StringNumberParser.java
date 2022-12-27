package stringcalc;

import java.util.ArrayList;
import java.util.List;

public class StringNumberParser {
    public List<Long> parse(String input, String separator) {
        if (input.isBlank()) {
            return new ArrayList<>();
        }
        if (separator == null) {
            String[] stringNumbers = input.split("[,:]");
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
            throw new RuntimeException();
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
