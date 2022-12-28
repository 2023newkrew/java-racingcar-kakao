package racingcar;

import racingcar.racing.Racing;
import racingcar.racing.RacingUI;

public class Main {
    public static void main(String[] args) {
        Racing racingGame = new Racing();
        RacingUI racingUi = new RacingUI();
        racingGame.init(racingUi.getNames(), racingUi.getTurn());
    }
}