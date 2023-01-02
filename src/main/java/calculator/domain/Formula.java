package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Formula {
    private static final String TYPE_EXCEPTION_MESSAGE = "[ERROR] 구분자로 구분되는 것은 정수여야 합니다.";
    private static final String RANGE_EXCEPTION_MESSAGE = "[ERROR] 모든 값은 0 이상이어야 합니다.";
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String SEPERATOR_FOR_DELIMITERS = "|";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DEFAULT_SUM = 0;
    private static final int MIN_INT_VALUE = 0;
    private String inputString;
    private String delimiters;

    public Formula(final String inputString) {
        this.inputString = inputString;
        this.delimiters = DEFAULT_DELIMITERS;
    }

    public int calculate() {
        if (inputString == null || inputString.isBlank()) {
            return DEFAULT_SUM;
        }
        customizeDelimiter();
        List<Integer> numbers = splitString();
        return numbers.stream().reduce(DEFAULT_SUM, Integer::sum);
    }

    private List<Integer> splitString() {
        List<Integer> tokens = Arrays.stream(inputString.split(delimiters))
                .map(this::validateInt)
                .collect(Collectors.toList());
        return tokens;
    }

    private void customizeDelimiter() {
        Matcher m = CUSTOM_PATTERN.matcher(inputString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiters += SEPERATOR_FOR_DELIMITERS + customDelimiter;
            inputString = m.group(2);
        }
    }

    private Integer validateInt(final String input) {
        try {
            Integer inputInt = Integer.parseInt(input);
            validateRange(inputInt);
            return inputInt;
        } catch (NumberFormatException e) {
            throw new RuntimeException(TYPE_EXCEPTION_MESSAGE);
        }
    }

    private void validateRange(final Integer inputInt) {
        if (inputInt < MIN_INT_VALUE) {
            throw new RuntimeException(RANGE_EXCEPTION_MESSAGE);
        }
    }
}
