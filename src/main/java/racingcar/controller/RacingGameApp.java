package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.view.RacingGameInfoReader;
import racingcar.view.RacingScoreboard;

import java.util.List;

public class RacingGameApp {

    private static final RacingGameInfoReader racingGameInfoReader = RacingGameInfoReader.getInstance();

    public static void main(String[] args) {
        List<RacingCar> racingCars = racingGameInfoReader.readRacingCars();
        RacingGame racingGame = new RacingGame(racingCars);
        int round = racingGameInfoReader.readRound();
        RacingScoreboard.printScore(racingCars);
        for (int roundNum = 0; roundNum < round; roundNum++) {
            racingGame.playRound();
            RacingScoreboard.printScore(racingCars);
        }
        RacingScoreboard.printWinners(racingGame.selectWinners());
    }
}
