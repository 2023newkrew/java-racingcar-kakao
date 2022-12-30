package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Winners;


public class RacingGameOutputView {

    public RacingGameOutputView() {
    }

    public void printCars(Cars cars) {
        System.out.println(cars);
        System.out.println();
    }

    public void printWinners(Winners winners) {
        System.out.println(winners.getWinnerNames() + "가 최종 우승했습니다.");
    }
}
