package racingcar;

import racingcar.domain.RacingCars;
import racingcar.service.RacingGame;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameScoreView;

public class RacingGameApp {
    private static RacingGameInputView racingGameInputView;
    private static RacingGameScoreView racingGameScoreView;

    public static void main(String[] args) {
        init();

        RacingCars racingCars = racingGameInputView.readRacingCars();
        int rounds = racingGameInputView.readRound();

        RacingGame racingGame = new RacingGame(racingCars, rounds);

        racingGameScoreView.printStartMessage(racingCars);

        while (!racingGame.isFinished()) {
            racingCars = racingGame.playRound();
            racingGameScoreView.printRacingCarDist(racingCars);
        }

        racingGameScoreView.printWinners(racingCars.findWinners());

        racingGameInputView.close();
    }

    private static void init() {
        racingGameInputView = new RacingGameInputView();
        racingGameScoreView = new RacingGameScoreView();
    }
}
