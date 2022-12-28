package racingcar;

import java.util.List;
import java.util.Random;
import racingcar.model.Positions;
import racingcar.model.RacingGame;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(System.out, System.in);
        OutputView outputView = new OutputView(System.out);

        List<String> carNames = inputView.inputCarNames();
        int maxTryCount = inputView.inputMaxTryCount();

        RacingGame racingGame = new RacingGame(maxTryCount, ()->new Random().nextInt(9), carNames);

        outputView.printExecuteResultMessage();

        while(!racingGame.isFinished()){
            racingGame.move();
            Positions positions = racingGame.getPositions();
            outputView.printPositions(positions);
        }

        Winners winners = racingGame.getWinners();
        outputView.printWinners(winners);
    }
}
