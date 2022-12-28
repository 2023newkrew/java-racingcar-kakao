package stringcalc;

import java.util.Scanner;

public class StringCalculatorApp {
    public static void main(String[] args) {
        StringCalculatorInputReader stringCalculatorInputReader = new StringCalculatorInputReader();
        String input = stringCalculatorInputReader.read();

        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.calculate(input));

        stringCalculatorInputReader.close();
    }
}
