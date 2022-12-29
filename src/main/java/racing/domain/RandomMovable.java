package racing.domain;

import java.util.Random;

public class RandomMovable implements Movable {

    private static final int BOUND = 10;
    private static final int THRESHOLD = 3;

    private final Random random;

    public RandomMovable(Random random) {
        this.random = random;
    }

    @Override
    public boolean isMove() {
        return random.nextInt(BOUND) > THRESHOLD;
    }
}
