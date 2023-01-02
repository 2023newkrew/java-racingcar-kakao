package calculator;

import calculator.domain.Formula;
import java.util.Scanner;

public class Application {
    private static final Scanner sc = new Scanner(System.in);
    private static final String INPUT_MESSAGE = "계산식을 입력해주세요.";
    private static final String OUTPUT_MESSAGE_FORMAT = "계산결과는 %d 입니다.";

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        try {
            play();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    private static void play() {
        String input = readInput();
        Formula formula = new Formula(input);
        int sum = formula.calculate();
        System.out.printf(OUTPUT_MESSAGE_FORMAT, sum);
    }

    private static String readInput() {
        System.out.println(INPUT_MESSAGE);
        return sc.nextLine();
    }
}
