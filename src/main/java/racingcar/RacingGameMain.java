package racingcar;

import racingcar.view.RacingGameInputView;

import java.util.Scanner;

public class RacingGameMain {

    public static void main(String[] args) {
        RacingGameInputView racingGameInputView = new RacingGameInputView();

        String carNames = racingGameInputView.getCarNames();
        Integer numberOfGames = racingGameInputView.getNumberOfGames();

        RacingGameRunner racingGame = new RacingGameRunner(carNames, numberOfGames);
        racingGame.run();
    }
}
