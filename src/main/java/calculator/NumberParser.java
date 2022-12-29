package calculator;

public class NumberParser {

    public int[] inputToIntArray(String input) throws NegativeValueException, NumberFormatException{
        return stringArrayToIntArray(inputToStringArray(input));
    }

    private String[] inputToStringArray(String input) {
        if (input == null || input.equals("")){
            input = "0";
        }
        DelimiterParser delimiterParser = new DelimiterParser(input);
        return delimiterParser.getPurifiedInputSplit();
    }

    private void checkNegativeValue(int val) throws NegativeValueException {
        if (val < 0){
            throw new NegativeValueException();
        }
    }
    private int[] stringArrayToIntArray(String[] stringArray) throws NumberFormatException, NegativeValueException {
        int[] result = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            result[i] = Integer.parseInt(stringArray[i]);
            checkNegativeValue(result[i]);
        }

        return result;
    }
}
