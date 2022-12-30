package racingcar.domain;

import java.util.Random;

public class MovableStrategy {
    private static final int RANDOM_MAX_NUMBER = 10;
    private static final int MOVING_LOWER_BOUND = 4;

    public Integer generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(RANDOM_MAX_NUMBER);
    }

    public boolean canMove(int number) {
        return number >= MOVING_LOWER_BOUND;
    }
}
