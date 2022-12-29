package racingcar.view;

import racingcar.domain.car.CarDTO;
import racingcar.domain.racing.RacingWinner;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printResult(RacingWinner winners) {
        System.out.println(winners);
    }

    public static void printTurnResult(List<CarDTO> proceedTurn) {
        proceedTurn.forEach(System.out::println);
        System.out.println();
    }
}
