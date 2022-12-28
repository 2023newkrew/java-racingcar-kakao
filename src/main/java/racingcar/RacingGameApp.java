package racingcar;

import java.util.List;

public class RacingGameApp {
    public static void main(String[] args) {
        RacingGameInfoReader racingGameInfoReader = new RacingGameInfoReader();
        List<RacingCar> racingCars = racingGameInfoReader.readRacingCars();
        int rounds = racingGameInfoReader.readRound();

        RacingGame racingGame = new RacingGame();
        racingGame.play(racingCars, rounds);

        racingGameInfoReader.close();
    }
}
