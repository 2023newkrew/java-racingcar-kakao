package racing;

import java.util.Random;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class Application {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo, new Random());
        ResultView.printSetup(racingGame);
        while(racingGame.isEnd()) {
            racingGame.race();
            ResultView.printCars(racingGame);
        }
        ResultView.printWinners(racingGame);
    }
}
