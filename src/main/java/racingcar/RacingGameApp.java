package racingcar;

import racingcar.domain.RacingCar;
import racingcar.service.RacingGame;
import racingcar.service.RacingGameReferee;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameScoreView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameApp {
    private static RacingGameInputView racingGameInputView;
    private static RacingGameScoreView racingGameScoreView;
    private static RacingGameReferee racingGameReferee;

    public static void main(String[] args) {
        init();

        List<RacingCar> racingCars = racingGameInputView.readRacingCars();
        int rounds = racingGameInputView.readRound();

        RacingGame racingGame = new RacingGame(racingCars, rounds);

        racingGameScoreView.printStartMessage(racingCars);

        List<RacingCar> result = new ArrayList<>();
        while (!racingGame.isFinished()) {
            result = racingGame.playRound();
            racingGameScoreView.printRacingCarDist(result);
        }

        List<RacingCar> winners = racingGameReferee.findWinners(result);
        racingGameScoreView.printWinners(winners);

        racingGameInputView.close();
    }

    private static void init() {
        racingGameInputView = new RacingGameInputView();
        racingGameScoreView = new RacingGameScoreView();
        racingGameReferee = new RacingGameReferee();
    }
}
