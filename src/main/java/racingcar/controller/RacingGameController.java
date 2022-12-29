package racingcar.controller;

import racingcar.domain.RacingCarName;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {

    public void start() {
        RacingGame racingGame = new RacingGame(InputView.inputCarNames(), InputView.inputFinalTurn());
        OutputView.printGameResultMessage();
        OutputView.printTurnResult(racingGame.getCars());
        while (!racingGame.isFinished()) {
            OutputView.printTurnResult(racingGame.proceedTurn());
        }
        OutputView.printWinners(racingGame.judgeWinners());
    }

}
