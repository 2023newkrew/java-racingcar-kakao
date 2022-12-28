package racingcar;

import racingcar.domain.Racing;
import racingcar.view.InputView;

public class Main {
    public static void main(String[] args) {
        Racing racing = new Racing();

        racing.generateCars(InputView.scanCarNames());
        racing.proceedRounds(InputView.scanTrialCount());

        System.out.println("최종결과");
        System.out.println(String.join(", ", racing.getTotalWinnersNames()) + "가 최종 우승했습니다.");
    }
}
