package racingcar.view;

import racingcar.domain.RacingCarName;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        List<String> carNames = null;
        while (carNames==null) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            carNames = tryInputCarNames();
        }
        return carNames;
    }

    private static List<String> tryInputCarNames() {
        try {
            return RacingCarName.parseCarNames(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static int inputFinalTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = "a";
        while (!input.matches("[0-9]+")) {
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }
}
