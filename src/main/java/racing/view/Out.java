package racing.view;

import racing.domain.Car;

import java.util.List;

public class Out {

    private final static String INPUT_NAMES_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String INPUT_COUNT_REQUEST = "시도할 회수는 몇회인가요?";
    private final static String RESULT_START_SENTENCE = "실행 결과";
    private final static String WINNER_MESSAGE_SUFFIX = "가 최종 우승했습니다.";

    public static void printText(String msg) {
        System.out.println(msg);
    }

    public static void printInputNameRequest() {
        printText(INPUT_NAMES_REQUEST);
    }

    public static void printInputCountRequest() {
        printText(INPUT_COUNT_REQUEST);
    }

    public static void printResultStartSentence() {
        printText(RESULT_START_SENTENCE);
    }

    public static void printResult(Car[] cars) {
        for (int index = 0; index < cars.length; index++) {
            printText(cars[index].getLog());
        }
        printText("");
    }

    public static void printWinners(List<String> winners) {
        printText(String.join(", ", winners) + WINNER_MESSAGE_SUFFIX);
    }

}
