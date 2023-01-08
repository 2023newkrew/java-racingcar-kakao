package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String REGEX_CARNAME = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        boolean inputIsValid = false;
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return Arrays.asList(scanner.nextLine().split(Input.REGEX_CARNAME));
    }

    public static int getTurnIteration() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
