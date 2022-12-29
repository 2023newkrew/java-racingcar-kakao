package racingcar;

import java.util.List;
import racingcar.model.NumberGenerator;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingSimulator {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingSimulator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void simulate(NumberGenerator numberGenerator) {
        RacingGame racingGame = createRacingGame(numberGenerator);

        outputView.printExecuteResultMessage();
        while (!racingGame.isFinished()) {
            racingGame.moveCars();
            outputView.printPositions(racingGame.getPositions());
        }
        outputView.printWinners(racingGame.getWinners());
    }

    private RacingGame createRacingGame(NumberGenerator numberGenerator) {
        List<String> carNames = inputView.inputCarNames();
        int maxTryCount = inputView.inputMaxTryCount();
        return new RacingGame(maxTryCount, numberGenerator, carNames);
    }
}
