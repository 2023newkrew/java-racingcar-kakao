package racingcar.step2.controller;

import racingcar.step2.domain.RacingGame;
import racingcar.step2.view.InputView;
import racingcar.step2.view.ResultView;

import java.util.List;

public class RacingGameController {

    private static final String MSG_PRINT_HEADER = "\n실행 결과";

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