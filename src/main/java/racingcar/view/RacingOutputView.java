package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingOutputView {


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
