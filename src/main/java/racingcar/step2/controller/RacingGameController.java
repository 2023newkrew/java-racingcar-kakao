package racingcar.step2.controller;

import racingcar.step2.domain.RacingGame;
import racingcar.step2.view.InputView;
import racingcar.step2.view.ResultView;

import java.util.List;

import static racingcar.step2.util.MessageConstants.MSG_PRINT_HEADER;

public class RacingGameController {
    public void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> carNames = inputView.inputCarNames();
        int tryNo = inputView.inputTurn();
        RacingGame racingGame = new RacingGame(carNames, tryNo);

        System.out.println(MSG_PRINT_HEADER);
        while (!racingGame.isEnd()) {
            racingGame.playTurn();
            resultView.printTurnResult(racingGame.getCars());
        }
        resultView.printGameResult(racingGame.getWinners());
    }
}