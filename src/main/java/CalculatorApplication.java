import stringcalculator.CalculatorRunner;
import stringcalculator.InputView;
import stringcalculator.OutputView;
import stringcalculator.StringParser;

public class CalculatorApplication {
    public static void main(String[] args) {
        StringParser stringParser = new StringParser();
        CalculatorRunner calculatorRunner = new CalculatorRunner(stringParser);
        Integer result = calculatorRunner.calculate(InputView.receiveInput());
        OutputView.printResult(result);
    }
}
