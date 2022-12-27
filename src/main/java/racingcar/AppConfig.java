package racingcar;

import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public interface AppConfig {

    public RandomNumberGenerator getRandomNumberGenerator();
    public InputView getInputView();
    public OutputView getOutputView();
}
