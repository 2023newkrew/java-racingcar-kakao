package racingcar.controller;

import racingcar.domain.racing.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();

    public void startRace() {
        Racing racingGame = new Racing(inputView.getNames(), inputView.getTurn());

        while (!racingGame.isEnd()) {
            OutputView.printTurnResult(racingGame.proceedTurn());
        }
        OutputView.printResult(racingGame.getWinners());
    }
}
