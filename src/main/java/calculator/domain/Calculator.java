package calculator.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    public int calculate(Command command) {
        return parsingNumbers(command)
                .getNumbers()
                .stream()
                .mapToInt(Number::getNumber)
                .sum();
    }


    private Numbers parsingNumbers(Command command) {
        String splitByDelimiterRegex = getSplitByDelimiterRegex(command);
        String[] splitNumbers = command.getInputStringNumbers()
                .split(splitByDelimiterRegex);
        return new Numbers(
                Stream.of(splitNumbers)
                        .map(str -> new Number(Integer.parseInt(str)))
                        .collect(Collectors.toList())
        );
    }

    private String getSplitByDelimiterRegex(Command command) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        command.getDelimiters().forEach(delimiter -> sb.append(delimiter.getDelimiter()));
        sb.append(']');
        return sb.toString();
    }

}
