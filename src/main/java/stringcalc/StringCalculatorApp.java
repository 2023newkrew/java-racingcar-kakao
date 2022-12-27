package stringcalc;

import java.util.Scanner;

public class StringCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        input = input.replaceAll("\\\\n", "\n");
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.calculate(input));
        scanner.close();
    }
}
