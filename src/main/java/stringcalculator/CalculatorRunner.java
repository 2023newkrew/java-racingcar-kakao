package stringcalculator;

public class CalculatorRunner {
    private StringParser parser;

    public CalculatorRunner(StringParser parser) {
        this.parser = parser;
    }

    public Integer calculate(String input) {
        return Calculator.add(parser.parse(input));
    }
}
