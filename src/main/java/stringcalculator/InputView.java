package stringcalculator;

import java.util.Scanner;

public class InputView {
    public static String receiveInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력해주세요: ");
        return sc.nextLine();
    }
}
