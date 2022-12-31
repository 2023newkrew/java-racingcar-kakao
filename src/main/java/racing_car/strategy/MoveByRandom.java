package racing_car.strategy;

import java.util.Random;

public class MoveByRandom implements MoveCarStrategy {

    private final Random random = new Random();

    private static final int MIN_RANGE_FOR_MOVE = 4;

    private static final int MAX_RANGE_FOR_MOVE = 9;

    private int generateRandomNumber() {
        return random.nextInt(MAX_RANGE_FOR_MOVE + 1);
    }

    public boolean isMovable() {
        int randomNumber = generateRandomNumber();
        return randomNumber >= MIN_RANGE_FOR_MOVE && randomNumber <= MAX_RANGE_FOR_MOVE;
    }
}
