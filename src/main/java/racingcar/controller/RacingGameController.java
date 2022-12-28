package racingcar.controller;

import racingcar.controller.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private RacingGame racingGame;
    private InputView InputView;
    private OutputView outputView;

    public RacingGameController() {
        this.racingGame = new RacingGame();
        this.InputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        racingGame.init(InputView.inputCarNames(),InputView.inputFinalTurn());
        outputView.printGameResultMessage();
        outputView.printTurnResult(racingGame.getCars());
        while(!racingGame.isFinished()) {
            outputView.printTurnResult(racingGame.proceedTurn());
        }
        outputView.printWinners(racingGame.judgeWinners());
    }
}
