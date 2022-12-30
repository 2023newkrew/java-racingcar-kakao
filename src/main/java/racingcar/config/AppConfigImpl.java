package racingcar.config;

import racingcar.generator.RandomNumberGenerator;
import racingcar.generator.RandomNumberGeneratorImpl;

public class AppConfigImpl implements AppConfig {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();

    @Override
    public RandomNumberGenerator getRandomNumberGenerator() {
        return randomNumberGenerator;
    }
}
