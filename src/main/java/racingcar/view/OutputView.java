package racingcar.view;

import racingcar.domian.Car;

import java.util.List;

public class OutputView {
    private static final String HYPHEN = "-";

    public static void printTurnResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + HYPHEN.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printGameResult(List<String> winners) {
        System.out.println(String.join(", ", winners) + "이(가) 최종 우승했습니다.");
    }
}
