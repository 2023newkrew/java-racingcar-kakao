package racingcar;

import racingcar.racing.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class Main {
    public static void main(String[] args) {
        Racing racingGame = new Racing();
        InputView inputView = new InputView();

        racingGame.init(inputView.getNames(), inputView.getTurn());
        OutputView.printResult(racingGame.startRace());
    }
}