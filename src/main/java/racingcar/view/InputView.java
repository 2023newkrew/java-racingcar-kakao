package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return parseCarNames(scanner.nextLine());
    }

    public List<String> parseCarNames(String s) {
        List<String> carNames = Arrays.asList(s.split(","));
        for (int i = 0; i < carNames.size(); i++) {
            carNames.set(i, (carNames.get(i) + "     ").substring(0, 5));
        }
        return carNames;
    }

    public int inputFinalTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = "a";
        while (!input.matches("[0-9]+")) {
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }
}
