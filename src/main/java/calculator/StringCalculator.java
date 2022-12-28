package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_NAME = "delimiter";
    private static final String CUSTOM_DELIMITER_REGEX = "//(?<" + CUSTOM_DELIMITER_NAME + ">.+)\n";

    public static int calculate(String text) {
        if (text == null || !isConsistedByPositiveNumbers(text)) {
            throw new IllegalArgumentException();
        }

        return reduceBySum(text);
    }

    private static boolean isConsistedByPositiveNumbers(String text) {
        String[] values = splitByDelimiter(text);

        return Stream.of(values)
                .allMatch(StringCalculator::isPositiveNumber);
    }

    private static String[] splitByDelimiter(String text) {
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String delimiter = matcher.group(CUSTOM_DELIMITER_NAME);
            return text.substring(matcher.group().length()).split(delimiter);
        }

        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private static boolean isPositiveNumber(String value) {
        return !(value == null || value.matches("\\D") || value.contains("-") || value.isBlank());
    }

    private static int reduceBySum(String text) {
        String[] values = splitByDelimiter(text);

        return Stream.of(values)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
