package racingcar;

import racingcar.controller.RacingGameController;

public class RacingGameApplication {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.play();
    }
}
