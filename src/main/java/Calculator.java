import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    public int calculate(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitInputToNumbers(input);
        Optional<Integer> result = Arrays.stream(numbers).map(this::parseToInt).reduce(Integer::sum);
        return result.orElse(-1);
    }

    private int parseToInt(String next) {
        return Integer.parseInt(next);
    }


    private String[] splitInputToNumbers(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return input.split("[,;]");
    }
}
