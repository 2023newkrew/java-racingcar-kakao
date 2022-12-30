package racingcar;

import racingcar.domian.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNameList = InputView.inputCarNameList();
        int turn = InputView.inputTurn();
        RacingGame racingGame = new RacingGame(carNameList, turn);

        while (!racingGame.isEnd()) {
            racingGame.play();
            OutputView.printTurnResult(racingGame.getCarList());
        }

        System.out.println("실행 결과");
        OutputView.printGameResult(racingGame.getWinners());
    }
}
