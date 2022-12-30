package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.view.RacingGameInfoReader;
import racingcar.view.RacingScoreboard;

import java.util.List;

public class RacingGameApp {
    public static void main(String[] args) {
        List<RacingCar> racingCars = RacingGameInfoReader.readRacingCars();
        RacingGame racingGame = new RacingGame(racingCars);
        int round = RacingGameInfoReader.readRound();
        RacingScoreboard.printScore(racingCars);
        for (int roundNum = 0; roundNum < round; roundNum++) {
            racingGame.playRound();
            RacingScoreboard.printScore(racingCars);
        }
        RacingScoreboard.printWinners(racingGame.selectWinners());
        RacingGameInfoReader.close();
    }
}
