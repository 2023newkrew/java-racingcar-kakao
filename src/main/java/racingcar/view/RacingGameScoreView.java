package racingcar.view;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingGameWinners;

public class RacingGameScoreView {
    public void printRacingCarDist(RacingCars racingCars) {
        System.out.println(racingCars + "\n");
    }

    public void printWinners(RacingGameWinners winners) {
        System.out.println(winners);
    }

    public void printStartMessage(RacingCars racingCars) {
        System.out.println("\n실행 결과");
        printRacingCarDist(racingCars);
    }
}
