package car_racing.view;

import car_racing.domain.InputVerifier;
import car_racing.domain.StringParser;

import java.util.Scanner;

public class InputView {
    private final static Scanner sc = new Scanner(System.in);

    public static String[] getPlayerNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputString = sc.nextLine();
        return StringParser.parse(inputString);
    }

    public static Integer getNumberOfTurns() {
        System.out.println("시도할 회수는 몇회인가요?");
        int turn = sc.nextInt();
        InputVerifier.verifyNumberIsPos(turn);
        return turn;
    }
}
