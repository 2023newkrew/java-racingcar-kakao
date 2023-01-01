package racingcar.view;

import racingcar.model.Car;

import java.util.List;

/**
 * 프로그램의 UI로직을 담당하는 클래스입니다.
 * 사용자 input도 여기에서 담당합니다.
 */
public class OutputView {
    private final static String COMMA = ",";
    private final static String SPACE = " ";
    final static String NEW_LINE = "\n";

    public void printInitialGameStatus(List<Car> cars) {
        System.out.println("실행 결과");
        printGameResult(cars);
    }

    public void printGameResult(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString() + NEW_LINE);
        }
        System.out.println(stringBuilder.toString());
    }

    public void printWinners(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners) {
            stringBuilder.append(winner.getName() + COMMA + SPACE);
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }
}
