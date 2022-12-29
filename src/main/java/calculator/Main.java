package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.print("커스텀 구분자 또는 계산할 문자열을 입력하세요: ");
        expression = scanner.nextLine();
        if (expression.startsWith("//")) {
            System.out.println("커스텀 구분자가 추가되었습니다. 계산할 문자열을 입력하세요.");
            expression += "\n" + scanner.nextLine();
        }

        System.out.println(calculator.calculate(expression.trim()));
    }
}
