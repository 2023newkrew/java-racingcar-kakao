package racingcar.view;

import java.util.Scanner;

public class GameView {

    private final Scanner scanner;

    public GameView() {
        scanner = new Scanner(System.in);
    }

    public String getCarNames() {
        System.out.println(ViewMessage.CAR_NAME_INPUT_MESSAGE.getMessage());
        return scanner.nextLine();
    }

    public int getRound() {
        System.out.println(ViewMessage.COUNT_INPUT_MESSAGE.getMessage());
        return scanner.nextInt();
    }

    public void printResult(String... results) {
        for (String result : results) {
            System.out.println(result);
        }
    }

    public void printInitialResult(String result) {
        printResult(ViewMessage.RESULT_TITLE.getMessage(), result);
    }

}