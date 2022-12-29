package racingcar;

import racingcar.domian.RacingGame;
import racingcar.ui.InputUI;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNameList = InputUI.inputCarNameList();
        int turn = InputUI.inputTurn();
        RacingGame racingGame = new RacingGame(carNameList, turn);

        System.out.println("실행 결과");
        racingGame.play();
    }
}
