package racingcar;

import racingcar.view.RacingGameRunner;

public class RacingGameMain {

    public static void main(String[] args) {
        RacingGameRunner racingGame = new RacingGameRunner();
        racingGame.inputData();
        racingGame.run();
    }
}
