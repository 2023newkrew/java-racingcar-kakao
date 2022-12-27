package stringcalc;

import java.util.Scanner;

public class StringCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.calculate(input));
    }
}
