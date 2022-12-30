package racingcar.util;

import java.util.Random;

public class RandomMovable implements Movable {
    private static final Random random = new Random();
    private final int threshold;
    private final int bound;

    public RandomMovable(int threshold, int bound) {
        this.threshold = threshold;
        this.bound = bound;
    }

    @Override
    public boolean canMove() {
        return random.nextInt(threshold) >= bound;
    }
}
