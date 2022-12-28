package StringCalculator;

import java.util.Scanner;

public class Main {
    private static StringSum stringSum;

    public static String inputString() {
        System.out.print("문자열을 입력해주세요. : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.startsWith("//")) {
            String input_2 = scanner.nextLine();
            input += "\n" + input_2;
        }
        return input;
    }

    public static void printAnswer(int answer) {
        System.out.println("합은 " + answer + "입니다.");
    }

    public static void main(String[] args) {
        String input = inputString();
        stringSum = new StringSum(input);
        printAnswer(stringSum.calculate());
    }
}
