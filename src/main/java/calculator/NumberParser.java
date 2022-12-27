package calculator;

import java.util.List;

public class NumberParser {
    private final String input;
    private final List<String> defaultDelimiters;
    private String[] stringArray;

    public NumberParser(String input, List<String> defaultDelimiters) {
        this.defaultDelimiters = defaultDelimiters;
        if (input == null || input.equals("")) {
            this.input = "0";
            return;
        }
        this.input = input;
    }

    public String[] inputToStringArray() {
        DelimiterParser delimiterParser = new DelimiterParser(input, defaultDelimiters);
        delimiterParser.checkCustomDelimiter();
        String delimiter = delimiterParser.getDelimiter();
        this.stringArray = delimiterParser.getPurifiedInput().split(delimiter);
        return this.stringArray;
    }

    private void checkNegativeValue(int val) throws NegativeValueException {
        if (val < 0){
            throw new NegativeValueException();
        }
    }
    public int[] stringArrayToIntArray() throws NumberFormatException, NegativeValueException {
        int[] result = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            result[i] = Integer.parseInt(stringArray[i]);
            checkNegativeValue(result[i]);
        }

        return result;
    }
}
