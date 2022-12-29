package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_NAME = "delimiter";
    private static final String CUSTOM_DELIMITER_REGEX = String.format("//(?<%s>.+)\n", CUSTOM_DELIMITER_NAME);
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static int calculate(String text) {
        if (isBlank(text) || !isConsistedByPositiveNumbers(text)) {
            throw new IllegalArgumentException();
        }

        return reduceBySum(text);
    }

    private static boolean isConsistedByPositiveNumbers(String text) {
        String[] splitValues = splitByDelimiter(text);

        return Stream.of(splitValues)
                .allMatch(StringCalculator::isPositiveNumber);
    }

    private static String[] splitByDelimiter(String text) {
        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (customDelimiterMatcher.find()) {
            String delimiter = customDelimiterMatcher.group(CUSTOM_DELIMITER_NAME);
            return text.substring(customDelimiterMatcher.group().length())
                    .split(delimiter);
        }

        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private static boolean isBlank(String value){
        return (value == null || value.isEmpty() || value.isBlank());
    }

    private static boolean isPositiveNumber(String value) {
        return !(isBlank(value) || value.matches("\\D") || value.contains("-"));
    }

    private static int reduceBySum(String text) {
        String[] splitValues = splitByDelimiter(text);

        return Stream.of(splitValues)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
