import stringcalculator.*;

public class CalculatorApplication {
    public static void main(String[] args) {
        StringParser stringParser = new StringParser();
        Calculator calculator = new Calculator(stringParser);
        Integer result = calculator.addString(InputView.receiveInput());
        OutputView.printResult(result);
    }
}
