package racingcar.controller;

import racingcar.domain.game.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void start() {
        RacingGame racingGame = new RacingGame(InputView.inputCarNames(), InputView.inputFinalTurn());
        OutputView.printGameResultMessage();
        OutputView.printTurnResult(racingGame.getCars());
        while (!racingGame.getTurnInfo().isFinished()) {
            OutputView.printTurnResult(racingGame.proceedTurn());
        }
        OutputView.printWinners(racingGame.judgeWinners());
    }

}
