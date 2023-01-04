package stringcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringNumberParser {

    public static final String DEFAULT_SEPARATOR = "[,:]";

    public static List<Long> parseToNumberList(String input, Optional<String> separator) {
        if (input.isBlank()) {
            return new ArrayList<>();
        }
        if (input.startsWith("//")) {
            input = input.substring("//.\n".length());
        }
        String[] stringNumbers = input.split(separator.orElse(DEFAULT_SEPARATOR));
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
