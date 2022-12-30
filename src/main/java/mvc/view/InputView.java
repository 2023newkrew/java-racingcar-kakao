package mvc.view;

import java.util.Scanner;

public abstract class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputCarNameStr() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public static int inputTotalTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        int totalTurns = sc.nextInt();
        return totalTurns;
    }
}
