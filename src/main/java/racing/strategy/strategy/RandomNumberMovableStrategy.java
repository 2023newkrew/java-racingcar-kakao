package racing.strategy.strategy;

import racing.strategy.interfaces.MovableStrategy;

import static racing.util.RandomNumberGenerator.generateRandomNumber;

public class RandomNumberMovableStrategy implements MovableStrategy {
    private static final int RANDOM_BOUND = 10;
    private static final int THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        return generateRandomNumber(RANDOM_BOUND) >= THRESHOLD;
    }
}
