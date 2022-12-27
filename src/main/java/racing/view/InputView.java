package racing.view;

import java.util.List;
import java.util.Scanner;
import racing.utils.InputValidator;

public class InputView {
    private final Scanner scanner;
    private final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String INPUT_REPEAT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final InputValidator validator;

    public InputView() {
        scanner = new Scanner(System.in);
        validator = new InputValidator();
    }

    public List<String> readCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        try {
            String input = scanner.nextLine();
            return validator.validateCarNames(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readCarNames();
        }
    }

    public int readGameRepeat() {
        System.out.println(INPUT_REPEAT_MESSAGE);
        try {
            String input = scanner.nextLine();
            return validator.validateGameRepeat(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameRepeat();
        }
    }
}
