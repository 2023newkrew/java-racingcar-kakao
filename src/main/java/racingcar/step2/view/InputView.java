package racingcar.step2.view;

import java.util.List;
import java.util.Scanner;

import static racingcar.step2.util.MessageConstants.MSG_INPUT_NAMES;
import static racingcar.step2.util.MessageConstants.MSG_INPUT_TURN;
import static racingcar.step2.util.RacingCarConstants.INPUT_SPLIT_DELIMITER;

public class InputView {

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
