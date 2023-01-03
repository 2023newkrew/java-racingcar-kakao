package racingcar.view;

import racingcar.domain.CarsManager;

import java.util.List;

public class ResultView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void printCars(CarsManager carsManager) {
        for (String status : carsManager.getCurrentStatus()) {
            printMessage(status);
        }
        printEmptyLine();
    }

    public void printWinners(List<String> winners) {
        printMessage(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public void printInitialStatus(CarsManager carsManager) {
        printMessage("실행 결과");
        printCars(carsManager);
    }
}
