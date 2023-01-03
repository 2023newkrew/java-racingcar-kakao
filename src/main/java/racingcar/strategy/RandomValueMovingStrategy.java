package racingcar.strategy;

import java.util.Random;

public class RandomValueMovingStrategy implements MovingStrategy {

    private final Random random = new Random();
    private static final int MOVING_THRESHOLD = 4;
    private static final int MAX_BOUND = 10;

    @Override
    public boolean movable() {
        return random.nextInt(MAX_BOUND) >= MOVING_THRESHOLD;
    }
}
