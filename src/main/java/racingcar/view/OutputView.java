package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printAskRunCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRunResult() {

        System.out.println("\n실행 결과");
    }

    public static void printEachRunResult(List<String> carResults) {
        carResults.forEach(System.out::println);
        System.out.println();
    }

    public static void printFinalResult(List<String> winnerNames) {
        System.out.println(String.join(" ,", winnerNames) + "가 최종 우승했습니다.");
    }
}
