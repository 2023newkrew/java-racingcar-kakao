package stringcalc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringNumberParser {
    public List<Long> parse(String input, String separator) {
//        String input = "1:2:3,4";
        // input
        if (separator == null) {
            String[] splitStrings = input.split("[,:]");
            return convertToNumbers(splitStrings);
        }
        return separateWithCustomSeparator(input, separator);
    }

    private List<Long> separateWithCustomSeparator(String input, String separator) {
        String stringNumber = input.substring("//.\n".length());
        String[] splitStrings = stringNumber.split(separator);
        return convertToNumbers(splitStrings);
    }

    private List<Long> convertToNumbers(String[] splitStrings) {
        List<Long> numbers = new ArrayList<>();
        for (String splitString : splitStrings) {
            numbers.add(convertToNumber(splitString));
        }
        if (numbers.stream().anyMatch(num -> num < 0)) {
            throw new RuntimeException();
        }
        return numbers;
    }

    private Long convertToNumber(String str) {
        try {
            return Long.parseLong(str);
        }catch (NumberFormatException ex) {
            throw new RuntimeException(ex);
        }
    }
}
