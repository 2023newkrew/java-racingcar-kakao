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
        return result.orElseThrow(() -> {throw new RuntimeException("입력된 숫자가 없습니다.");});
    }

    private int parseToInt(String next) {
        try {
            return parseToIntLogic(next);
        } catch (NumberFormatException e) {
            throw new RuntimeException("잘못된 숫자가 입력되었습니다.");
        }
    }

    private int parseToIntLogic(String next) {
        int result = Integer.parseInt(next);
        if (result < 0) {
            throw new NumberFormatException();
        }
        return result;
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
