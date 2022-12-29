package racingcar.domain;

import racingcar.config.GameSetting;
import racingcar.utils.RandomNumberGenerator;

public class RandomNumberMovable implements Movable {

    private RandomNumberGenerator randomNumberGenerator;

    public RandomNumberMovable() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Override
    public boolean isMovable() {
        return randomNumberGenerator.generateBetweenZeroAndNine() >= GameSetting.MOVABLE_MIN_VALUE;
    }

}
