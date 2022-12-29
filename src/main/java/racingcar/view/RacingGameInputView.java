package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class RacingGameInputView {
    private final Scanner scanner;

    public RacingGameInputView() {
        this(new Scanner(System.in));
    }

    public RacingGameInputView(Scanner scanner) {
        this.scanner = scanner;
    }


    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        return List.of(carNames.split(","));
    }

    public int getNumberOfGames() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
