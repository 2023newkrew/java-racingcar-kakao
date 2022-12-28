package racingcar.view;

import racingcar.domain.car.CarDTO;

import java.util.List;

public class OutputView {
    public static void printResult(List<String> winners) {
        winners.forEach(System.out::println);
    }

    public static void printTurnResult(List<CarDTO> proceedTurn) {
        proceedTurn.forEach(System.out::println);
        System.out.println();
    }
}
