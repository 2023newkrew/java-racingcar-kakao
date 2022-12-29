package CarRacing.view;

import java.util.Scanner;

public class InputView {
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return getUserInput();
    }

    public static int inputCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        int tryCount;
        try {
            tryCount = Integer.parseInt(getUserInput());
        } catch(Exception e) {
            System.out.println("숫자를 입력하세요");
            return inputCount();
        }
        return tryCount;
    }
}
