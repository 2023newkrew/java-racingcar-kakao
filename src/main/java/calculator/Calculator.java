package calculator;

import java.util.List;
import java.util.Optional;

public class Calculator {

    private final Parser parser;

    private String delimiters = ",:";
    private List<Number> numbers;

    public Calculator(String input) {
        this.parser = new Parser(input);
    }

    public int run() {
        numbers = getNumbersToAdd();
        return addNum();
    }

    private List<Number> getNumbersToAdd() {
        checkDelimiter();
        return parser.splitContent(delimiters);
    }

    private void checkDelimiter() {
        Optional<String> customDelimiter = parser.getCustomDelimiter();
        customDelimiter.ifPresent(cd -> delimiters += cd);
    }

    private int addNum() {
        return numbers.stream()
                .map(Number::getValue)
                .mapToInt(Integer::intValue)
                .sum();
    }
}