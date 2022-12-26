package calculator;

public class NumberParser {
    private final String input;
    private String[] stringArray;

    public NumberParser(String input) {
        this.input = input;
    }

    public String[] inputToStringArray() {
        DelimiterParser delimiterParser = new DelimiterParser(input);
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
