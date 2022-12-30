import string_calculator.CalculatorRunner;
import string_calculator.InputView;
import string_calculator.OutputView;
import string_calculator.StringParser;

public class CalculatorApplication {
    public static void main(String[] args) {
        StringParser stringParser = new StringParser();
        CalculatorRunner calculatorRunner = new CalculatorRunner(stringParser);
        Integer result = calculatorRunner.calculate(InputView.receiveInput());
        OutputView.printResult(result);
    }
}
