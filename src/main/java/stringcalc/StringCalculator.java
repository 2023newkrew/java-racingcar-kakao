package stringcalc;

import java.util.List;
import java.util.Optional;

public class StringCalculator {

    private Long sum(List<Long> numbers) {
        return numbers.stream().reduce(0L, Long::sum);
    }

    public Long calculate(String input) {
        Optional<String> customSeparator = CustomSeparatorParser.parseToCustomSeparator(input);
        List<Long> numbers = StringNumberParser.parseToNumberList(input, customSeparator);
        return sum(numbers);
    }
}
