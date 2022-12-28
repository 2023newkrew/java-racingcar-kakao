package stringcalc;

import java.util.Scanner;

public class StringCalculatorInputReader {

    private final Scanner scanner;

    public StringCalculatorInputReader() {
        scanner = new Scanner(System.in);
    }

    public String read() {
        String input = scanner.next();
        return input.replace("\\n", "\n");
    }

    public void close() {
        scanner.close();
    }
}
