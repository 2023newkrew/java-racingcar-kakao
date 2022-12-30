package racingcar.config;

import racingcar.generator.RandomNumberGenerator;
import racingcar.generator.RandomNumberGeneratorImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfigImpl implements AppConfig {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();

    @Override
    public RandomNumberGenerator getRandomNumberGenerator() {
        return randomNumberGenerator;
    }
}
