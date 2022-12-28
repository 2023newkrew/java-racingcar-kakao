package racingcar.config;

import racingcar.controller.RacingCarGameController;
import racingcar.controller.RacingCarGameControllerImpl;
import racingcar.domain.RacingCarGameImpl;
import racingcar.generator.RandomNumberGenerator;
import racingcar.generator.RandomNumberGeneratorImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfigImpl implements AppConfig {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarGameController racingCarGameController = new RacingCarGameControllerImpl(inputView,
            outputView, new RacingCarGameImpl(randomNumberGenerator));

    @Override
    public RandomNumberGenerator getRandomNumberGenerator() {
        return randomNumberGenerator;

    }

    @Override
    public InputView getInputView() {
        return inputView;
    }

    @Override
    public OutputView getOutputView() {
        return outputView;
    }

    @Override
    public RacingCarGameController getRacingCarGameController() {
        return racingCarGameController;
    }
}
