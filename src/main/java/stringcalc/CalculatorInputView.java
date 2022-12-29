package stringcalc;

import java.util.Scanner;

public class CalculatorInputView {
    public static String inputNumberString(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();
        return input.replaceAll("\\\\n", "\n");
    }
}
