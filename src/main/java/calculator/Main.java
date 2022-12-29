package calculator;

public class Main {

    public static void main(String[] args) {
        String input = InputUI.inputExpression();
        if (input.equals("0")) {
            System.out.println("= 0");
            return;
        }

        Calculator calculator = new Calculator(input);
        System.out.println("= " + calculator.run());
    }
}