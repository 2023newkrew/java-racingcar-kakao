package racing.view;

import java.util.List;
import java.util.Scanner;
import racing.utils.InputValidator;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_GAME_TURN_MESSAGE = "시도할 회수는 몇회인가요?";
    private final Scanner scanner;
    private final InputValidator validator;

    public InputView() {
        scanner = new Scanner(System.in);
        validator = new InputValidator();
    }

    public String readCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readCarNames();
        }
    }

    public int readGameTurn() {
        System.out.println(INPUT_GAME_TURN_MESSAGE);
        try {
            String input = scanner.nextLine();
            return validator.validateGameTurn(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameTurn();
        }
    }
}
