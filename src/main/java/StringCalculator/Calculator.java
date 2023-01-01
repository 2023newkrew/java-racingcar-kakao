package stringCalculator;

import stringCalculator.domain.Delimiter;
import stringCalculator.domain.Summation;
import stringCalculator.view.In;
import stringCalculator.view.Out;

public class Calculator {

    public static boolean textException(String inputString) {
        if(inputString == null || inputString.isBlank()) return false;
        return true;
    }

    public static void main(String[] args) {
        Out.printInputStringRequest();
        String input = In.inputString();
        if (!textException(input)) {
            Out.printBlankOrNullResponse();
            return;
        }
        Delimiter delimiter = new Delimiter(input);
        Summation summation = new Summation(delimiter.getInputString());
        int result = summation.calculate(delimiter.getDelimiterRegEx());
        Out.printResult(result);
    }

}
