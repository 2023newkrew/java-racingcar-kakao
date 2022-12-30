package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void printRoundResult(List<Car> roundResult) {
        for (Car car : roundResult) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.print(String.join(", ", winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
