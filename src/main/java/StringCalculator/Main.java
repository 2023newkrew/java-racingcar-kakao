package stringCalculator;

import stringCalculator.domain.StringSum;
import stringCalculator.view.In;
import stringCalculator.view.Out;

import java.util.Scanner;

public class Main {
    private static StringSum stringSum;

//    public static String inputString() {
//        String input = In.inputString();
//        if(input.startsWith("//")) {
//            String input_2 = scanner.nextLine();
//            input += "\n" + input_2;
//        }
//        return input;
//}

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
        stringSum = new StringSum(input);
        Out.printResult(stringSum.calculate());
    }
}
