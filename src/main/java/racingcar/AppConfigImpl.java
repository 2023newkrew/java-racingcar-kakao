package racingcar;

import racingcar.generator.RandomNumberGenerator;
import racingcar.generator.RandomNumberGeneratorImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfigImpl implements AppConfig{
    public RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();
    public InputView inputView = new InputView();
    public OutputView outputView = new OutputView();

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
}
