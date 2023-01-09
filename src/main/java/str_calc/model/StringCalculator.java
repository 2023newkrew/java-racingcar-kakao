package str_calc.model;

import java.util.List;

public class StringCalculator {
    private TextParser textParser;

    public StringCalculator() {
        this.textParser = new TextParser();
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
        return this.sum(IntegerConverter.toIntList(splitText));
    }
}
