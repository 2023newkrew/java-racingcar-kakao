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
        text = stringCalculator.extractDelimiter(text);
        io.printSum(stringCalculator.sumText(text));
    }
}
