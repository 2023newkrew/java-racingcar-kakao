package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    static final String REGEX_INTEGER = "[0-9]+";
    static final int NAME_LENGTH_LIMIT = 5;
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    private boolean isValidName(String name) {
        if (name.isEmpty() || name.length() > NAME_LENGTH_LIMIT) {
            return false;
        }
        return true;
    }

    private boolean isValidNames(List<String> names) {
        boolean isValid = true;
        for (String name : names) {
            isValid = isValid && this.isValidName(name);
        }
        return isValid;
    }

    public List<String> getCarNames() {
        boolean inputIsValid = false;
        List<String> carNames = new ArrayList<>();
        while (!inputIsValid) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            carNames = Arrays.asList(scanner.nextLine().split(","));
            inputIsValid = this.isValidNames(carNames);
        }
        return carNames;
    }

    private boolean isValidTurnIteration(String turnIteration) {
        return turnIteration.isEmpty() || !turnIteration.matches(Input.REGEX_INTEGER);
    }

    public int getTurnIteration() {
        boolean inputIsValid = false;
        String turnIteration = "";
        while (!inputIsValid) {
            System.out.println("시도할 회수는 몇회인가요?");
            turnIteration = scanner.nextLine();
            inputIsValid = this.isValidTurnIteration(turnIteration);
        }
        return Integer.parseInt(turnIteration);
    }
}
