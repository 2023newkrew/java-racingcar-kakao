package stringcalc;

public class StringCalculatorApp {
    public static void main(String[] args) {
        String input = CalculatorInputView.inputNumberString();
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.calculate(input));
    }
}
