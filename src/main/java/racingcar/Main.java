package racingcar;

import racingcar.domain.racing.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class Main {
    public static void main(String[] args) {
        Racing racingGame = new Racing();
        InputView inputView = new InputView();

        racingGame.init(inputView.getNames(), inputView.getTurn());

        while (!racingGame.isEnd()) {
            OutputView.printTurnResult(racingGame.proceedTurn());
        }
        OutputView.printResult(Racing.getWinners(racingGame.getCarDTOs()));
    }
}