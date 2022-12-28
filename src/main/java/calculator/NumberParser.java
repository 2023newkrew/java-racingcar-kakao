package calculator;

import java.util.List;

public class NumberParser {
    private final String numbersStr;
    private final List<String> defaultDelimiters;
    private String[] parsedNumbers;

    public NumberParser(String input, List<String> defaultDelimiters) {
        this.defaultDelimiters = defaultDelimiters;
        if (input == null || input.equals("")) {
            this.numbersStr = "0";
            return;
        }
        this.numbersStr = input;
    }

    public String[] inputToStringArray() {
        DelimiterParser delimiterParser = new DelimiterParser(numbersStr, defaultDelimiters);
        delimiterParser.checkCustomDelimiter();
        String delimiter = delimiterParser.getDelimiter();
        this.parsedNumbers = delimiterParser.getPurifiedInput().split(delimiter);
        return this.parsedNumbers;
    }

    private void checkNegativeValue(int val) throws NegativeValueException {
        if (val < 0){
            throw new NegativeValueException();
        }
    }
    public int[] stringArrayToIntArray() throws NumberFormatException, NegativeValueException {
        int[] result = new int[parsedNumbers.length];
        for (int i = 0; i < parsedNumbers.length; i++) {
            result[i] = Integer.parseInt(parsedNumbers[i]);
            checkNegativeValue(result[i]);
        }

        return result;
    }
}
