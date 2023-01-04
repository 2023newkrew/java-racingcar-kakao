package racingcar.step2.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String MSG_INPUT_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MSG_INPUT_TURN = "시도할 횟수는 몇 회인가요?";
    private static final String INPUT_SPLIT_DELIMITER = ",";

    private final Scanner sc = new Scanner(System.in);

    public List<String> inputCarNames() {
        System.out.println(MSG_INPUT_NAMES);
        String input = sc.nextLine();
        return List.of(input.split(INPUT_SPLIT_DELIMITER));
    }

    public int inputTurn() {
        System.out.println(MSG_INPUT_TURN);
        return sc.nextInt();
    }
}
