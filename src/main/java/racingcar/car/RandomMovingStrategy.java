package racingcar.car;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int MAX_RANDOM_BOUNDARY = 10;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        return new Random().nextInt(MAX_RANDOM_BOUNDARY) >= MOVE_THRESHOLD;
    }
}
