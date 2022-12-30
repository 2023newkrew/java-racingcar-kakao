package CarRacing.domain;

import CarRacing.util.RandomUtil;

public class RandomValueMovingStrategy implements MovingStrategy {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean movable() {
        return generateRandomNumber() >= MOVE_THRESHOLD;
    }

    private int generateRandomNumber() {
        return RandomUtil.generateRandomNumber(RANDOM_NUMBER_RANGE);
    }
}
