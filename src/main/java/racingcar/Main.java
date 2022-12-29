package racingcar;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.scanCarNames();
        int trialCount = InputView.scanTrialCount();

        Racing racing = new Racing();
        racing.generateCars(carNames);

        ResultView.printRacingStart();
        for (int i = 0; i < trialCount; i++) {
            racing.proceedRound();
            ResultView.printCars(racing.cars());
        }

        ResultView.printWinners(racing.getTotalWinners());
    }
}
