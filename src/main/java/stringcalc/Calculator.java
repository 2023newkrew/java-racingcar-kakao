package stringcalc;

import java.util.List;

public class Calculator {

    private final StringNumberParser stringNumberParser;
    private final CustomSeparatorParser customSeparatorParser;

    public Calculator() {
        stringNumberParser = new StringNumberParser();
        customSeparatorParser = new CustomSeparatorParser();
    }

    private Long sum(List<Long> numbers) {
        return numbers.stream().reduce(0L, Long::sum);
    }

    public Long calculate(String input) {
        String customSeparator = customSeparatorParser.parse(input);
        List<Long> numbers = stringNumberParser.parse(input, customSeparator);
        return sum(numbers);
    }
}
