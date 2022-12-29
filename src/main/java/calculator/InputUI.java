package calculator;

import java.util.Scanner;

public class InputUI {

    private static final Scanner sc = new Scanner(System.in);

    public static String inputExpression() {
        System.out.println("계산식을 입력하세요");
        String input = sc.nextLine();
        if (input == null || input.isBlank()) {
            return "0";
        }

        return input;
    }
}
