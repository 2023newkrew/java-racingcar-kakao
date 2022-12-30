package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameScoreView {
    public void printRacingCarDist(List<RacingCar> racingCars) {
        racingCars.forEach(System.out::println);
        System.out.println();
    }

    public void printWinners(List<RacingCar> racingCars) {
        String winners = racingCars.stream()
                .map(RacingCar::getRacingCarName)
                .map(RacingCarName::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    public void printStartMessage(List<RacingCar> racingCars) {
        System.out.println("\n실행 결과");
        printRacingCarDist(racingCars);
    }
}
