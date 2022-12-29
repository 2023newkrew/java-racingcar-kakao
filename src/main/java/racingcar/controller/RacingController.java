package racingcar.controller;

import racingcar.domain.racing.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final Racing racingGame = new Racing();
    private final InputView inputView = new InputView();

    public void startRace() {
        racingGame.init(inputView.getNames(), inputView.getTurn());

        while (!racingGame.isEnd()) {
            OutputView.printTurnResult(racingGame.proceedTurn());
        }
        OutputView.printResult(racingGame.getWinners());
    }
}
