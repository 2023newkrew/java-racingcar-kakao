package racingcar.view;

import racingcar.model.Cars;
import racingcar.model.FarthestCars;

public class Output {
    public static void displayGameResultMessage() {
        System.out.println("실행 결과");
    }

    public static void displayTurnResult(Cars cars) {
        System.out.println(cars.toString());
    }

    public static void displayWinners(FarthestCars winners) {
        System.out.println(winners.toString() + "가 최종 우승했습니다.");
    }
}
