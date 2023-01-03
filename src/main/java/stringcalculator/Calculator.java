package stringcalculator;

import java.util.Arrays;

public class Calculator {
    private final Parser<String> stringParser;

    public Calculator(Parser<String> stringParser) {
        this.stringParser = stringParser;
    }

    public Integer addString(String input) {
        return this.addInteger(stringParser.parse(input));
    }

    public Integer addInteger(Integer[] inputs) {
        return Arrays.stream(inputs).reduce(0, Integer::sum);
    }
}
