package calculator;

import calculator.domain.TargetString;
import java.util.Scanner;

public class Application {

    private static final Scanner sc = new Scanner(System.in);

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
        TargetString targetString = new TargetString(input);
        int sum = targetString.calculate();
        System.out.println("계산결과는 " + sum + " 입니다.");
    }

    private static String readInput() {
        System.out.println("계산식을 입력해주세요.");
        return sc.nextLine();
    }

}



