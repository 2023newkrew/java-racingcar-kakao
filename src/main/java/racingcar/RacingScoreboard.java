package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingScoreboard {
    public void printScore(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void printWinners(List<RacingCar> racingCars) {
        String winners = racingCars.stream().map(RacingCar::getName).collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
