package racingcar.view;

import racingcar.controller.RacingController;
import racingcar.model.Car;
import racingcar.model.RacingCar;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingView {

    private final Scanner scanner = new Scanner(System.in);

    private final RacingController racingController;

    public RacingView(RacingController racing) {
        this.racingController = racing;
    }

    public void inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분) ");
        String names = scanner.nextLine();
        racingController.processCarNames(names);
    }

    public void inputTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String trialNumber = scanner.nextLine();
        racingController.processTrialNumber(trialNumber);
    }

    public void printRoundResult() {
        System.out.println("*** 실행결과 ***");
        List<RacingCar> cars = racingController.getCarsForPrintRoundResult();
        cars.forEach(car -> System.out.println(car.getName() + ": " + "-".repeat(car.getPosition())));
        System.out.println();
    }


    public void printWinners() {
        String DELIMITER = ",";
        List<RacingCar> winners = racingController.getWinners();
        String joinedWinners = winners.stream().map(Car::getName).collect(Collectors.joining(DELIMITER));

        System.out.println("최종결과");
        System.out.println(joinedWinners + "가 최종 우승했습니다.");
    }
}
