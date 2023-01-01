package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RacingCar;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingView {

    private final Scanner scanner = new Scanner(System.in);


    public String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분) ");
        return scanner.nextLine();
    }

    public String inputTrialNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextLine();
    }

    public void printRoundResult(List<RacingCar> cars) {
        System.out.println("*** 실행결과 ***");
        cars.forEach(car -> System.out.println(car.getName() + ": " + "-".repeat(car.getPosition())));
        System.out.println();
    }


    public void printWinners(List<RacingCar> winners) {
        String DELIMITER = ",";
        String joinedWinners = winners.stream().map(Car::getName).collect(Collectors.joining(DELIMITER));

        System.out.println("최종결과");
        System.out.println(joinedWinners + "가 최종 우승했습니다.");
    }
}
