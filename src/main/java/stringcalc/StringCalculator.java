package stringcalc;

import java.util.List;

public class StringCalculator {

    private Long sum(List<Long> numbers) {
        return numbers.stream().reduce(0L, Long::sum);
    }

    public Long calculate(String input) {
        String customSeparator = CustomSeparatorParser.parseToCustomSeparator(input);
        List<Long> numbers = StringNumberParser.parseToNumberList(input, customSeparator);
        return sum(numbers);
    }
}
