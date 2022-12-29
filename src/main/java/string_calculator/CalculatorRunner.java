package string_calculator;

import java.util.Scanner;

public class CalculatorRunner {
    private StringParser parser;

    public CalculatorRunner(StringParser parser) {
        this.parser = parser;
    }

    public void run() {
        String input = receiveInput();
        Integer result;
        result = calculate(input);
        printResult(result);
    }

    private String receiveInput() {
        Scanner sc = new Scanner(System.in);
        String retString = "";
        System.out.print("문자열을 입력해주세요: ");
        retString = sc.next();
        return retString;
    }

    private Integer calculate(String input) {
        return Calculator.add(parser.parse(input));
    }

    private void printResult(Integer result) {
        System.out.printf("Result : %d\n", result);
    }

}
