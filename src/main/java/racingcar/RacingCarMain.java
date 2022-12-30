package racingcar;

import racingcar.config.AppConfigImpl;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCarGameImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printStartMessage();
        String[] carNames = inputView.inputName();

        outputView.printAskRunCount();
        int runCount = inputView.inputRunCount();

        RacingCarGame racingCarGame = new RacingCarGameImpl(new AppConfigImpl(), carNames);
        outputView.printRunResult();

        for (int i = 0; i < runCount; i++) {
            racingCarGame.race();
            outputView.printEachRunResult(racingCarGame.getCars()
                    .getEachCarResults());
        }

        outputView.printFinalResult(racingCarGame.getCars()
                .getWinnerName());
    }
}
