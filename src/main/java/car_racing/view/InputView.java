package car_racing.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner sc = new Scanner(System.in);

    public static String[] getPlayerNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputString = sc.nextLine();
        String[] splitStrings = inputString.split(",", -1);
        for (String name : splitStrings) {
            verifyName(name);
        }
        return splitStrings;
    }

    public static Integer getNumberOfTurns() {
        System.out.println("시도할 회수는 몇회인가요?");
        int turn = sc.nextInt();
        if (turn <= 0) {
            throw new RuntimeException("Invalid number for turns");
        }
        return turn;
    }

    private static void verifyName(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new RuntimeException("Invalid Name");
        }
    }
}
