package calculator;

import java.util.List;

public class NumberParser {
    private final String numbersStr;
    private final List<String> defaultDelimiters;
    private String[] parsedNumbers;

    public NumberParser(String input, List<String> defaultDelimiters) {
        this.defaultDelimiters = defaultDelimiters;
        this.numbersStr = (input == null || input.equals("")) ? "0" : input;
    }

    public String[] parseNumbersStr() {
        DelimiterParser delimiterParser = new DelimiterParser(numbersStr, defaultDelimiters);
        String delimiter = delimiterParser.getDelimiter();
        parsedNumbers = delimiterParser.getProcessedInput().split(delimiter);
        return parsedNumbers;
    }

    private void checkNegativeNumber(int val) throws NegativeValueException {
        if (val < 0) {
            throw new NegativeValueException();
        }
    }

    public int[] convertParsedNumbersToIntArr() throws NumberFormatException, NegativeValueException {
        int[] result = new int[parsedNumbers.length];
        for (int i = 0; i < parsedNumbers.length; i++) {
            result[i] = Integer.parseInt(parsedNumbers[i]);
            checkNegativeNumber(result[i]);
        }

        return result;
    }
}
