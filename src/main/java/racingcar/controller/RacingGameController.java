package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingGame racingGame = new RacingGame(inputView.inputCarNames(),inputView.inputFinalTurn());
        outputView.printGameResultMessage();
        outputView.printTurnResult(racingGame.getCars());
        while(!racingGame.isFinished()) {
            outputView.printTurnResult(racingGame.proceedTurn());
        }
        outputView.printWinners(racingGame.judgeWinners());
    }

}
