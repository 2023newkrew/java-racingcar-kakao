package str_calc;

public class CalculatorController {
    private StringCalculator stringCalculator;
    private IOView ioView;

    public CalculatorController() {
        this.stringCalculator = new StringCalculator();
        this.ioView = new IOView();
    }
    public void start() {
        String text = ioView.inputText();
        text = stringCalculator.extractSeperator(text);
        System.out.println(text);
        ioView.printSum(stringCalculator.sumText(text));
    }
}
