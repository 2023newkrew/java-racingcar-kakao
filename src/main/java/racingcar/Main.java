package racingcar;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {
    public static void main(String[] args) {
        Racing racing = new Racing();

        racing.generateCars(InputView.scanCarNames());
        int trialCount = InputView.scanTrialCount();

        ResultView.printRacingStart();
        for (int i = 0; i < trialCount; i++) {
            racing.proceedRound();
            ResultView.printCars(racing.cars());
        }

        System.out.println("최종결과");
        System.out.println(String.join(", ", racing.getTotalWinnersNames()) + "가 최종 우승했습니다.");
    }
}
