package str_calc;

public class Controller {
    private StringCalculator stringCalculator;
    private IO io;

    public Controller() {
        this.stringCalculator = new StringCalculator();
        this.io = new IO();
    }
    public void start() {
        String text = io.inputText();
        text = stringCalculator.getTextThatDelimiterIsExtracted(text);
        io.printSum(stringCalculator.sum(text));
    }
}
