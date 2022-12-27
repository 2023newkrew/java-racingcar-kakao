package racingcar;

import racingcar.view.InputView;

public class RacingGameController {

    private InputView InputView;

    public RacingGameController() {
        this.InputView = new InputView();
    }

    public void start() {
        RacingGame racingGame = new RacingGame(InputView.inputCarNames(),InputView.inputFinalTurn());
        racingGame.playGame();
    }
}
