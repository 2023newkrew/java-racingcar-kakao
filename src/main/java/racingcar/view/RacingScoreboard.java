package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingScoreboard {
    public static void printScore(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public static void printWinners(List<RacingCar> racingCars) {
        String winners = racingCars.stream().map(RacingCar::getName).collect(Collectors.joining(", "));
        System.out.println(winners + Message.IS_WINNER_MESSAGE.getMessage());
    }
}
