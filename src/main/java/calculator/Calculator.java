package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    private static final String DEFAULT_DELIMITER = "[,;]";

    public int calculate(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitInputToNumbers(input);
        Optional<Integer> result = Arrays.stream(numbers).map(this::parseStringToZeroAllPositiveInt).reduce(Integer::sum);
        return result.orElseThrow(() -> {
            throw new RuntimeException("입력된 숫자가 없습니다.");
        });
    }

    private int parseStringToZeroAllPositiveInt(String input) {
        try {
            return checkZeroOrPositive(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new RuntimeException("0 이상의 숫자만 입력해야합니다.");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private int checkZeroOrPositive(int input) {
        if (input < 0) {
            throw new IllegalArgumentException();
        }
        return input;
    }


    private String[] splitInputToNumbers(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
