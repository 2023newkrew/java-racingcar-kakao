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

        ResultView.printWinners(racing.getTotalWinners());
    }
}
