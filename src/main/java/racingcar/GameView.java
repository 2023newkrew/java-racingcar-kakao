package racingcar;

import java.util.Scanner;

public class GameView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_TITLE = "\n실행 결과";

    private Scanner scanner;

    public GameView() {
        scanner = new Scanner(System.in);
    }

    public String getCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public int getCount() {
        System.out.println(COUNT_INPUT_MESSAGE);
        return scanner.nextInt();
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }
}
