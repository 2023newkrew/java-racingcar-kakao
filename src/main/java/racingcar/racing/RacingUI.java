package racingcar.racing;

import java.util.Scanner;

public class RacingUI {
    private final Scanner sc = new Scanner(System.in);

    public String getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.next();
    }

    public String getTurn() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return sc.next();
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
