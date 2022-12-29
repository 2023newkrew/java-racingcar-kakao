package str_calc.model;

import java.util.List;

public class StringCalculator {
    private TextParser textParser;
    private IntegerConverter integerConverter;

    public StringCalculator() {
        this.textParser = new TextParser();
        this.integerConverter = new IntegerConverter();
    }

    private int sum(List<Integer> intList) {
        int sum = 0;
        for (int elem : intList) {
            sum += elem;
        }
        return sum;
    }

    public int sum(String text) {
        List<String> splitText = this.textParser.splitText(text);
        return this.sum(this.integerConverter.toIntList(splitText));
    }
}
