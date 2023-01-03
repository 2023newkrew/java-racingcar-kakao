package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGameWinners;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameScoreView {
    public void printRacingCarDist(RacingCars racingCars) {
        System.out.println(racingCars + "\n");
    }

    public void printWinners(RacingGameWinners winners) {
        List<RacingCar> winnerCars = winners.getWinners();
        String winnerNames = winnerCars.stream()
                .map(RacingCar::getRacingCarName)
                .map(RacingCarName::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void printStartMessage(RacingCars racingCars) {
        System.out.println("\n실행 결과");
        printRacingCarDist(racingCars);
    }
}
