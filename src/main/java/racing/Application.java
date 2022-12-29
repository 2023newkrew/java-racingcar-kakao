package racing;

import java.util.Random;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class Application {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame();
        racingGame.create(carNames);

        ResultView.printSetup(racingGame);
        for (int i = 0; i < tryNo; i++) {
            racingGame.race(new Random());
            ResultView.printCars(racingGame);
        }
        ResultView.printWinners(racingGame);
    }
}
