package str_calc;

import str_calc.model.StringCalculator;

public class Controller {
    private StringCalculator stringCalculator;
    private IO io;

    public Controller() {
        this.stringCalculator = new StringCalculator();
        this.io = new IO();
    }

    public void start() {
        String text = io.inputText();
        io.printSum(stringCalculator.sum(text));
    }
}
