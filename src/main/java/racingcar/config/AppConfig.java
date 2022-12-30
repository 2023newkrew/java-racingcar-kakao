package racingcar.config;

import racingcar.controller.RacingCarGameController;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public interface AppConfig {

    RandomNumberGenerator getRandomNumberGenerator();
    InputView getInputView();
    OutputView getOutputView();

    RacingCarGameController getRacingCarGameController();

}
