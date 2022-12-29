package racing.view;

import racing.domain.Car;

import java.util.List;

public class Out {

    private final static String WINNER_MESSAGE_SUFFIX = "가 최종 우승했습니다.";

    public static void printText(String msg) {
        System.out.println(msg);
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
