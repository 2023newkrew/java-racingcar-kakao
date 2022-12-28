package racing.movable;

import racing.utils.RandomNumberGenerator;

public class RandomlyMovable implements Movable {
    public static final int MOVING_LOWER_BOUND = 4;

    @Override
    public boolean isMoving() {
        int randomNumber = generateRandomNumber();
        return randomNumber >= MOVING_LOWER_BOUND;
    }

    private int generateRandomNumber() {
        return RandomNumberGenerator.generate();
    }
}
