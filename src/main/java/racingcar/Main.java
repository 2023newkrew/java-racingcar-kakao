package racingcar;

import racingcar.domian.RacingGame;
import racingcar.ui.InputUI;
import racingcar.ui.OutputUI;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNameList = InputUI.inputCarNameList();
        int turn = InputUI.inputTurn();
        RacingGame racingGame = new RacingGame(carNameList, turn);

        while (!racingGame.isEnd()) {
            racingGame.play();
            OutputUI.printTurnResult(racingGame.getCarList());
        }

        System.out.println("실행 결과");
        OutputUI.printGameResult(racingGame.getWinners());
    }
}
