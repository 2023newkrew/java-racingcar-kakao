package racingcar;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> carNameList = InputUI.inputCarNameList();
        int turn = InputUI.inputTurn();
        RacingGame racingGame = new RacingGame(carNameList, turn);

        System.out.println("실행 결과");
        racingGame.play();
    }
}
