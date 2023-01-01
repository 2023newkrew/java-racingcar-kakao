package racingcar.view;

import racingcar.domain.Cars;

import java.util.List;

public class ResultView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printCars(Cars cars) {
        for (String status : cars.getCurrentStatus()) {
            printMessage(status);
        }
        printEmptyLine();
    }

    public void printWinners(List<String> winners) {
        printMessage(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public void printInitialStatus(Cars cars) {
        printMessage("실행 결과");
        printCars(cars);
    }
}
