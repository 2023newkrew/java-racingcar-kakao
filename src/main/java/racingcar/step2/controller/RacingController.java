package racingcar.step2.controller;

import racingcar.step2.domain.RacingGame;
import racingcar.step2.view.RacingInputView;
import racingcar.step2.view.RacingOutputView;

public class RacingController {

    RacingInputView racingInputView = new RacingInputView();
    RacingOutputView racingOutputView = new RacingOutputView();

    public void gamePlay() {
        String carNames = racingInputView.getCarNames();
        int tryNo = racingInputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        racingOutputView.printRaceStart(racingGame.getCars());
        while (!racingGame.isEnd()) {
            racingGame.race();
            racingOutputView.printCars(racingGame.getCars());
        }
        racingOutputView.printWinners(racingGame.getWinners());
    }
}
