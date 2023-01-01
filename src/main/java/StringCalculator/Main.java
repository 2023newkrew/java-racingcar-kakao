package stringCalculator;

import stringCalculator.domain.Delimiter;
import stringCalculator.domain.StringSum;
import stringCalculator.view.In;
import stringCalculator.view.Out;

import java.util.Scanner;

public class Main {
    private static StringSum stringSum;

    public static boolean textException(String inputString) {
        if(inputString == null) return false;
        if(inputString.isEmpty()) return false;
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
        stringSum = new StringSum(input);
        Out.printResult(stringSum.calculate());
    }
}
