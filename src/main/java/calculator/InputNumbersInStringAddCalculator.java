package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputNumbersInStringAddCalculator {
    private static final String TYPE_EXCEPTION_MESSAGE = "[ERROR] 구분자로 구분되는 것은 정수여야 합니다.";
    private static final String RANGE_EXCEPTION_MESSAGE = "[ERROR] 모든 값은 0 이상이어야 합니다.";
    private static final String DEFAULT_DELIMITERS = ",|:";
    private final String inputString;
    private final String delimiters;
    private final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public InputNumbersInStringAddCalculator(String inputString) {
        this.inputString = getInputStringTodAdd(inputString);
        this.delimiters = DEFAULT_DELIMITERS + getCustomDelimiter(inputString);
    }

    public String getInputStringTodAdd(String inputString) {
        if (inputString == null || inputString.isBlank()) return inputString;
        Matcher m = CUSTOM_PATTERN.matcher(inputString);
        if (m.find()) {
            return (m.group(2));
        }
        return inputString;
    }
    private String getCustomDelimiter(String inputString) {
        if (inputString == null || inputString.isBlank()) return "";
        Matcher m = CUSTOM_PATTERN.matcher(inputString);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = '|' + m.group(1);
        }
        return customDelimiter;
    }

    public int calculate() {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        List<Integer> numbers = splitString();
        return numbers.stream().reduce(0, Integer::sum);
    }

    private List<Integer> splitString() {
        List<Integer> tokens = Arrays.stream(inputString.split(delimiters))
                .map(this::validateInt)
                .collect(Collectors.toList());
        return tokens;
    }

    private Integer validateInt(String input) {
        try {
            Integer inputInt = Integer.parseInt(input);
            validateRange(inputInt);
            return inputInt;
        } catch (NumberFormatException e) {
            throw new RuntimeException(TYPE_EXCEPTION_MESSAGE);
        }
    }

    private void validateRange(Integer inputInt) {
        if (inputInt < 0) {
            throw new RuntimeException(RANGE_EXCEPTION_MESSAGE);
        }
    }
}
