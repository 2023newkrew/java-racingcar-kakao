package racingcar;

import java.util.List;

public class RacingGameApp {
    public static void main(String[] args) {
        RacingGameInputView racingGameInputView = new RacingGameInputView();
        List<RacingCar> racingCars = racingGameInputView.readRacingCars();
        int rounds = racingGameInputView.readRound();

        RacingGame racingGame = new RacingGame();
        racingGame.play(racingCars, rounds);

        racingGameInputView.close();
    }
}
