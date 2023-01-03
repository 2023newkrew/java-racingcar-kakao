package racingcar;

import java.util.List;
import racingcar.model.NumberGenerator;
import racingcar.model.RacingGame;
import racingcar.model.RacingResult;
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

        RacingResult racingResult = racingGame.start();
        outputView.printRacingResult(racingResult);
    }

    private RacingGame createRacingGame(NumberGenerator numberGenerator) {
        List<String> carNames = inputView.inputCarNames();
        int maxRound = inputView.inputMaxRound();
        return new RacingGame(maxRound, numberGenerator, carNames);
    }
}
