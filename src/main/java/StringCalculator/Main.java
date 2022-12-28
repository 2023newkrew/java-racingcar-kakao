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

    public static boolean textException(String inputString) {
        if(inputString == null) return false;
        if(inputString.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        String input = inputString();
        if (!textException(input)) {
            System.out.println("합은 0입니다.");
            return;
        }
        stringSum = new StringSum(input);
        System.out.println("합은 " + stringSum.calculate() + "입니다.");
    }
}
