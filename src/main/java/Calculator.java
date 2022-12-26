import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Calculator {
    public int calculate(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.split("[,;]");
        Optional<Integer> result = Arrays.stream(numbers).map(this::parseToInt).reduce(Integer::sum);
        return result.orElse(-1);
    }

    private int parseToInt(String next) {
        return Integer.parseInt(next);
    }
}
