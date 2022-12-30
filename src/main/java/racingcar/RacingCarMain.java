package racingcar;

import racingcar.config.AppConfigImpl;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCarGameImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarMain {
    public static void main(String[] args) {
        OutputView.printStartMessage();
        String[] carNames = InputView.inputName();

        OutputView.printAskRunCount();
        int runCount = InputView.inputRunCount();

        RacingCarGame racingCarGame = new RacingCarGameImpl(new AppConfigImpl(), carNames);
        OutputView.printRunResult();

        for (int i = 0; i < runCount; i++) {
            racingCarGame.race();
            OutputView.printEachRunResult(racingCarGame.getCars()
                    .getEachCarResults());
        }

        OutputView.printFinalResult(racingCarGame.getCars()
                .getWinnerName());
    }
}
