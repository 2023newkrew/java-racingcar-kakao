package racingcar;

import racingcar.generator.RandomNumberGenerator;
import racingcar.generator.RandomNumberGeneratorImpl;

public class AppConfigImpl implements AppConfig{
    public RandomNumberGenerator randomNumberGenerator = new RandomNumberGeneratorImpl();

    public RandomNumberGenerator getRandomNumberGenerator() {
        return randomNumberGenerator;
    }
}
